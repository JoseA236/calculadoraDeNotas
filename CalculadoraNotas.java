import java.util.Scanner;

class CalculadoraNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUMERO_MINIMO_MATERIAS = 1;
        final int NUMERO_MAXIMO_MATERIAS = 10;
        int numeroMaterias = 0;
        boolean cantidadApropiadaMaterias;

        do {
            System.out.println("En cuántas materias estás inscrito?");
            System.out.println("Entre 1 - 10 materias.");
            numeroMaterias = scanner.nextInt();
            cantidadApropiadaMaterias = numeroMaterias >= NUMERO_MINIMO_MATERIAS && numeroMaterias <= NUMERO_MAXIMO_MATERIAS;
            
        } while (!cantidadApropiadaMaterias);

        String[] materias = new String[numeroMaterias];
        double[] notas = new double[numeroMaterias];

        System.out.println("Estás inscrito en " + numeroMaterias + " materias");
        scanner.nextLine();

        for (int i = 0; i < materias.length; i++) {
            System.out.println("Introduce el nombre de la materia " + (i+1) + ":");
            materias[i] = scanner.nextLine();
        }

        System.out.println();

        final double NOTA_MINIMA_APROBADO = 5.0;
        final int NOTA_MAXIMA = 10;
        final int NOTA_MINIMA = 0;
        boolean notaValida;
        double notasTotales = 0;
        int materiasAprobadas = 0;
        int materiasSuspensas = 0;
        double notaMinima = NOTA_MAXIMA;
        double notaMaxima = NOTA_MINIMA;
        int peorMateria = 0;
        int mejorMateria = 0;
        
        for (int i = 0; i < notas.length; i++) {
            
            do {
                System.out.println("Introduce la nota de " + materias[i] + ":");
                notas[i] = scanner.nextDouble();
                notaValida = notas[i] >= NOTA_MINIMA && notas[i] <= NOTA_MAXIMA;
            } while (!notaValida);
            
            notasTotales = notasTotales + notas[i];
            if (notas[i] >= NOTA_MINIMA_APROBADO) {
                materiasAprobadas++;
            } else {
                materiasSuspensas++;
            }
            
            if (notas[i] < notaMinima) {
                notaMinima = notas[i];
                peorMateria = i;
            } 
            
            if (notas[i] > notaMaxima) {
                notaMaxima = notas[i];
                mejorMateria = i;
            }


        }

        double promedioNotas = (double) notasTotales / numeroMaterias;
        promedioNotas = Math.round(promedioNotas * 100.0) / 100.0;
        System.out.println();
        System.out.println("Resumen de notas:");
        System.out.println();


        for (int i=0; i < notas.length; i++) {
            System.out.println(materias[i] + " - " + notas[i]);
        }
        System.out.println();
        System.out.println("Promedio de notas: " + promedioNotas);
        System.out.println("Materias aprobadas: " + materiasAprobadas);
        System.out.println("Materias suspensas: " + materiasSuspensas);
        System.out.println("Mejor materia: " + materias[mejorMateria] + " Nota: " + notaMaxima);
        System.out.println("Peor materia: " + materias[peorMateria] + " Nota: " + notaMinima);


        scanner.close();
    }

}
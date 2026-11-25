import java.util.Scanner;

class CalculadoraNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroMaterias = consultarNumeroMaterias(scanner);

        String[] materias = new String[numeroMaterias];
        double[] notas = new double[numeroMaterias];

        preguntarNombreMaterias(materias, scanner);
        solicitarNotas(scanner, materias, notas);
        mostrarResumen(notas, materias);

        scanner.close();
    }

    static int consultarNumeroMaterias( Scanner scanner) {
        final int NUMERO_MINIMO_MATERIAS = 1;
        final int NUMERO_MAXIMO_MATERIAS = 10;
        int numeroMaterias = 0;
        boolean cantidadApropiadaMaterias;

        do {
            System.out.println("En cuántas materias estás inscrito?");
            System.out.println("Entre 1 - 10 materias.");
            numeroMaterias = scanner.nextInt();
            cantidadApropiadaMaterias = numeroMaterias >= NUMERO_MINIMO_MATERIAS
                    && numeroMaterias <= NUMERO_MAXIMO_MATERIAS;

        } while (!cantidadApropiadaMaterias);
        scanner.nextLine();

        System.out.println("Estás inscrito en " + numeroMaterias + " materias");
        return numeroMaterias;
    }

    static void preguntarNombreMaterias(String[] materias, Scanner scanner) {

        for (int i = 0; i < materias.length; i++) {
            System.out.println("Introduce el nombre de la materia " + (i + 1) + ":");
            materias[i] = scanner.nextLine();
        }
    }

    static void solicitarNotas(Scanner scanner, String[] materias, double[] notas) {
        final int NOTA_MAXIMA = 10;
        final int NOTA_MINIMA = 0;
        boolean notaValida;

        for (int i = 0; i < notas.length; i++) {
            do {
                System.out.println("Introduce la nota de " + materias[i] + ":");
                notas[i] = scanner.nextDouble();

                notaValida = notas[i] >= NOTA_MINIMA
                        && notas[i] <= NOTA_MAXIMA;

            } while (!notaValida);
        }
    }

    static int contarAprobadas(double[] notas) {
        final double NOTA_MINIMA_APROBADO = 5.0;
        int materiasAprobadas = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= NOTA_MINIMA_APROBADO) {
                materiasAprobadas++;
            }
        }
        return materiasAprobadas;
    }

    static int contarSuspensas(double[] notas) {
        return notas.length - contarAprobadas(notas);
    }

    static double promedioNotas(double[] notas) {
        double materias = notas.length;
        double notaTotal = 0;
        for (int i = 0; i < notas.length; i++) {
            notaTotal = notaTotal + notas[i];
        }
        double promedioNotas = Math.round((notaTotal / materias) * 100.0) / 100.0;
        return promedioNotas;
    }

    static int calcularMejorMateria(double[] notas) {
        double notaMaxima = 0;
        int indiceNotaMaxima = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notaMaxima < notas[i]) {
                notaMaxima = notas[i];
                indiceNotaMaxima = i;
            }
        }

        return indiceNotaMaxima;
    }

    static int calcularPeorMateria(double[] notas) {
        double notaMinima = 10;
        int indiceNotaMinima = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notaMinima > notas[i]) {
                notaMinima = notas[i];
                indiceNotaMinima = i;
            }
        }

        return indiceNotaMinima;
    }

    static void mostrarResumen(double[] notas, String[] materias) {
        System.out.println("Resumen de notas:");
        System.out.println();

        int mejorMateria = calcularMejorMateria(notas);
        int peorMateria = calcularPeorMateria(notas);

        for (int i = 0; i < notas.length; i++) {
            System.out.println(materias[i] + " - " + notas[i]);
        }
        System.out.println();
        System.out.println("Promedio de notas: " + promedioNotas(notas));
        System.out.println("Materias aprobadas: " + contarAprobadas(notas));
        System.out.println("Materias suspensas: " + contarSuspensas(notas));
        System.out.println(
                "Mejor materia: " + materias[mejorMateria] + " Nota: " + notas[mejorMateria]);
        System.out.println(
                "Peor materia: " + materias[peorMateria] + " Nota: " + notas[peorMateria]);
    }
}
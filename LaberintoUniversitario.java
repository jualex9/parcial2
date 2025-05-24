import java.util.Random;
import java.util.Scanner;

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int[][] laberinto = new int[5][5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generar el laberinto con valores aleatorios del 1 al 9
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[fila].length; col++) {
                laberinto[fila][col] = random.nextInt(9) + 1;
            }
        }

        // Mostrar el laberinto generado
        System.out.println("=== LABERINTO UNIVERSITARIO ===");
        mostrarMatriz(laberinto);

        // Instrucciones del reto
        System.out.println("""
                ¡Bienvenido al Laberinto Universitario!
                Este sistema representa los pasillos secretos de tu facultad.
                Cada número indica un nivel de energía en ese punto.
                Tu misión es explorar este laberinto cumpliendo los siguientes desafíos:

                1. Contar cuántos números pares hay mayores a 4. ⚡
                2. Calcular el promedio de los números impares. 🎯
                3. Calcular la suma de los valores de cada fila. 🧮
                4. BONUS: Encuentra la posición del mayor número del laberinto. 👑
                """);

        // Aquí puedes invocar los métodos para cada uno de los puntos anteriores
        // Por ejemplo:
        // contarParesMayoresA4(laberinto);
        // promedioImpares(laberinto);
        // etc...

        contarPares(laberinto);
        promedioImpares(laberinto);
        sumarFilas(laberinto);
        encontrarMayor(laberinto);
        scanner.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void contarPares(int[][] matriz) {
        int totalPares = 0;
        for (int[] fila : matriz) {
            for (int num : fila) {
                if (num % 2 == 0 && num > 4) {
                    totalPares++;
                }
            }
        }
        System.out.println("Cantidad de números pares mayores a 4: " + totalPares);
    }

    public static void promedioImpares(int[][] matriz) {
        int suma = 0;
        int totalImpares = 0;
        for (int[] fila : matriz) {
            for (int num : fila) {
                if (num % 2 != 0) {
                    suma += num;
                    totalImpares++;
                }
            }
        }
        if (totalImpares > 0) {
            double promedio = (double) suma / totalImpares;
            System.out.println("Promedio de los numeros impares: " + promedio);
        } else {
            System.out.println("No hay numeros impares en la matriz");
        }
    }

    public static void sumarFilas(int[][] matriz) {
        System.out.println("Suma de los numeros fila");
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            System.out.println("Fila " + (i + 1) + ": " + suma);
        }
    }

    public static void encontrarMayor(int[][] matriz) {
        int mayor = matriz[0][0];
        int filaMayor = 0;
        int colMayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    colMayor = j;
                }
            }
        }
        System.out.println(
                "El número más alto es " + mayor + " y esta en fila " + filaMayor + " y columna " + colMayor + "");
    }
}
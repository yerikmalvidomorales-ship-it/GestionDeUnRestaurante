package reto1.yerikmalvido;

import java.util.Scanner;

public class Reto1YerikMalvido {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de datos: ");
        int n = teclado.nextInt();

        double[] vector = new double[n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
        System.out.print("Ingrese el valor IRCA " + (i + 1) + ": ");
        vector[i] = teclado.nextDouble();
        suma = suma + vector[i];
}

        double maximo = vector[0];
        double minimo = vector[0];

        for (int i = 0; i < n; i++) {
            if (vector[i] > maximo) {
                maximo = vector[i];
            }
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }

        double promedio = suma / n;

        String riesgoPromedio = "";
        if (promedio > 80 && promedio <= 100) {
            riesgoPromedio = "INVIABLE SANITARIAMENTE";
        } else if (promedio > 35 && promedio <= 80) {
            riesgoPromedio = "ALTO";
        } else if (promedio > 14 && promedio <= 35) {
            riesgoPromedio = "MEDIO";
        } else if (promedio > 5 && promedio <= 14) {
            riesgoPromedio = "BAJO";
        } else if (promedio >= 0 && promedio <= 5) {
            riesgoPromedio = "SIN RIESGO";
        }

        String riesgoMaximo = "";
        if (maximo > 80 && maximo <= 100) {
            riesgoMaximo = "INVIABLE SANITARIAMENTE";
        } else if (maximo > 35 && maximo <= 80) {
            riesgoMaximo = "ALTO";
        } else if (maximo > 14 && maximo <= 35) {
            riesgoMaximo = "MEDIO";
        } else if (maximo > 5 && maximo <= 14) {
            riesgoMaximo = "BAJO";
        } else if (maximo >= 0 && maximo <= 5) {
            riesgoMaximo = "SIN RIESGO";
        }

        String riesgoMinimo = "";
        if (minimo > 80 && minimo <= 100) {
            riesgoMinimo = "INVIABLE SANITARIAMENTE";
        } else if (minimo > 35 && minimo <= 80) {
            riesgoMinimo = "ALTO";
        } else if (minimo > 14 && minimo <= 35) {
            riesgoMinimo = "MEDIO";
        } else if (minimo > 5 && minimo <= 14) {
            riesgoMinimo = "BAJO";
        } else if (minimo >= 0 && minimo <= 5) {
            riesgoMinimo = "SIN RIESGO";
        }

        System.out.println("Riesgo promedio: " + riesgoPromedio);
        System.out.println("Riesgo máximo: " + riesgoMaximo);
        System.out.println("Riesgo mínimo: " + riesgoMinimo);

        teclado.close();
    }
}

    

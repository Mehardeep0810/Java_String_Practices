package Assigned5.level3;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        String[][] bmiTable = buildBMITable(data);
        displayBMITable(bmiTable);
        sc.close(); 
    }

    public static String[][] buildBMITable(double[][] data) {
        String[][] table = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            table[i][0] = String.valueOf(heightCm);
            table[i][1] = String.valueOf(weight);
            table[i][2] = String.valueOf(bmi);
            table[i][3] = getBMIStatus(bmi);
        }
        return table;
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void displayBMITable(String[][] table) {
        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.println((i + 1) + "\t" +
                table[i][0] + "\t\t" +
                table[i][1] + "\t\t" +
                table[i][2] + "\t" +
                table[i][3]);
        }
    }
}
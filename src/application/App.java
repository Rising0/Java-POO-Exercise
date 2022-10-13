package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> payers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int taxPayers = sc.nextInt();

        for (int i = 0; i < taxPayers; i++) {
            System.out.printf("\nTax payer #%d data:\n", (i + 1));

            System.out.print("Individual or Company (i/c)? ");
            char payerType = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            TaxPayer payer;

            if (payerType == 'i') {

                System.out.print("Health expenditures: ");
                double healthExpending = sc.nextDouble();

                payer = new Individual(name, annualIncome, healthExpending);
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();

                payer = new Company(name, annualIncome, numberOfEmployees);
            }

            payers.add(payer);
        }

        System.out.println("\nTAXES PAID:");

        double totalTaxes = 0.0;

        for (TaxPayer payer : payers) {
            System.out.println(payer);
            totalTaxes += payer.tax();
        }

        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
    }
}

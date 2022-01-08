package com.kosiasuzu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much can you spend");
        double value = scanner.nextDouble();

        BudgetAllocationCalculation.setBudget(value);

        System.out.println("Enter your proportion of various expenses..");
        System.out.println("The system stops if cumulative proportion exceeds 100%");

        do {
            BudgetAllocationCalculation.showExpenseTable();
            System.out.printf("Enter the name of the expense %d :", BudgetAllocationCalculation.getNumberOfProportions() + 1);

            scanner.nextLine(); // Remove next line after entering a digit
            String proportionName = scanner.nextLine();
            System.out.printf("Enter the amount of the expense %s :", proportionName);
            double amount = scanner.nextDouble();

            Expense expense = new Expense(proportionName, amount);
            boolean wentThrough = BudgetAllocationCalculation.addExpense(expense);
            if(!wentThrough){
                System.out.println("Expense allocation exceeds budget amount");
            }
        } while(BudgetAllocationCalculation.isNotFull());

        System.out.println("Your final expense table is : ");
        BudgetAllocationCalculation.showExpenseTable();

        scanner.close();
    }
}

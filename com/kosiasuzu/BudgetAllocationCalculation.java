package com.kosiasuzu;

import java.util.ArrayList;

public class BudgetAllocationCalculation {

    private static double budget;
    private static final ArrayList<Expense>proportions = new ArrayList<Expense>();

    public static void setBudget(double x){
        budget = x;
    }

    public static double getBudget(){
        return budget;
    }

    public static int getNumberOfProportions(){
        return proportions.size();
    }

    public static boolean addExpense(Expense expense){
        // It will return true if the expense could be added and
        // false if expense could not be added because it will exceed 100%
        double total = getTotal();
        total += expense.amount;
        if(total > budget ){
            // failed to add new expense since it exceeds 100%
            return false;
        }
        else{
            // expense added to proportion
            proportions.add(expense);
            return true;
        }
    }

    private static double getTotal(){
        int total = 0;
        for(Expense expense: proportions){
            total += expense.amount;
        }

        return total;
    }
    public static boolean isNotFull(){
        return getTotal() != budget;
    }

    public static void showExpenseTable(){
        for(Expense expense: proportions){
            System.out.printf("Expense %s took %.1f%% of your budget which cost %.1f $ \n", expense.name, expense.amount, ((expense.amount * 100)/ budget));
        }
    }
}

package services;

public class BudgetManager {

    private double monthlyBudget = 0;

    public void setBudget(double amount) {
        monthlyBudget = amount;
        System.out.println("Budget Set Successfully!");
    }

    public void checkStatus(double totalSpent) {
        System.out.println("\nTotal Spent: ₹" + totalSpent);
        System.out.println("Budget: ₹" + monthlyBudget);

        if (totalSpent > monthlyBudget)
            System.out.println("⚠️ Alert: You have exceeded your budget!");
        else
            System.out.println("Remaining: ₹" + (monthlyBudget - totalSpent));
    }
}

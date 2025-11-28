package controllers;

import services.*;
import models.Expense;
import java.util.*;

public class MenuController {

    private Scanner sc = new Scanner(System.in);
    private ExpenseManager expenseManager = new ExpenseManager();
    private AnalyticsEngine analytics = new AnalyticsEngine();
    private BudgetManager budgetManager = new BudgetManager();
    private ReportGenerator reportGen = new ReportGenerator();

    public void start() {

        while (true) {
            System.out.println("\n==== Smart Personal Finance Manager ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Analytics");
            System.out.println("4. Budget Manager");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1 -> addExpenseUI();
                case 2 -> viewExpensesUI();
                case 3 -> analyticsUI();
                case 4 -> budgetUI();
                case 5 -> reportGen.generateReport(expenseManager.getAllExpenses());
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    private void addExpenseUI() {
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        expenseManager.addExpense(title, amount, category, date);
    }

    private void viewExpensesUI() {
        List<Expense> list = expenseManager.getAllExpenses();

        System.out.println("\n--- All Expenses ---");
        for (Expense e : list) System.out.println(e);
    }

    private void analyticsUI() {
        List<Expense> list = expenseManager.getAllExpenses();

        analytics.categoryWiseSummary(list);
        System.out.println("Highest Spending Category: " +
                analytics.highestCategory(list));
        System.out.println("Total Spent: ₹" + analytics.totalSpent(list));
    }

    private void budgetUI() {
        System.out.print("Set Budget Amount: ");
        double b = sc.nextDouble();

        budgetManager.setBudget(b);
        budgetManager.checkStatus(analytics.totalSpent(expenseManager.getAllExpenses()));
    }
}

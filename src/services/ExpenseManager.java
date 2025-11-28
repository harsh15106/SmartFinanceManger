package services;

import models.Expense;
import storage.StorageManager;
import java.util.*;

public class ExpenseManager {

    private List<Expense> expenses;
    private StorageManager storage;

    public ExpenseManager() {
        storage = new StorageManager();
        expenses = storage.loadExpenses();
    }

    public void addExpense(String title, double amount, String category, String date) {
        int id = expenses.size() + 1;
        Expense e = new Expense(id, title, amount, category, date);
        expenses.add(e);
        storage.saveExpenses(expenses);
        System.out.println("Expense Added Successfully!");
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
        storage.saveExpenses(expenses);
        System.out.println("Expense Deleted!");
    }

    public double getTotalThisMonth(String month) {
        return expenses.stream()
                .filter(e -> e.getDate().startsWith(month))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<Expense> getByCategory(String cat) {
        List<Expense> list = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(cat)) list.add(e);
        }
        return list;
    }
}

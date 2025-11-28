package services;

import models.Expense;
import java.util.*;

public class AnalyticsEngine {

    public void categoryWiseSummary(List<Expense> expenses) {
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.getCategory(),
                    map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\n--- Category Summary ---");
        map.forEach((k, v) -> System.out.println(k + " : ₹" + v));
    }

    public String highestCategory(List<Expense> expenses) {
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : expenses)
            map.put(e.getCategory(), map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public double totalSpent(List<Expense> expenses) {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}

package storage;

import models.Expense;
import java.io.*;
import java.util.*;

public class StorageManager {

    private final String FILE_PATH = "data/expenses.csv";

    // Read CSV
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(FILE_PATH);

        try {
            if (!file.exists()) file.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                Expense exp = new Expense(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Double.parseDouble(parts[2]),
                        parts[3],
                        parts[4]
                );
                expenses.add(exp);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error loading CSV: " + e.getMessage());
        }
        return expenses;
    }

    // Write CSV
    public void saveExpenses(List<Expense> expenses) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Expense e : expenses) {
                bw.write(e.getId() + "," + e.getTitle() + "," + e.getAmount() + "," +
                        e.getCategory() + "," + e.getDate());
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            System.out.println("Error saving CSV: " + e.getMessage());
        }
    }
}

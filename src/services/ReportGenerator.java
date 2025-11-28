package services;

import models.Expense;
import java.io.*;
import java.util.*;

public class ReportGenerator {

    public void generateReport(List<Expense> expenses) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/report.txt"));

            bw.write("---- Monthly Expense Report ----\n\n");

            for (Expense e : expenses)
                bw.write(e.toString() + "\n");

            bw.write("\nTotal Spent: ₹" +
                    expenses.stream().mapToDouble(Expense::getAmount).sum());

            bw.close();
            System.out.println("Report Generated (data/report.txt)");

        } catch (Exception e) {
            System.out.println("Report Error: " + e.getMessage());
        }
    }
}

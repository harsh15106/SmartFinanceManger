# Smart Personal Finance Manager (Java)

A modular Java-based application that helps users manage expenses, analyze spending patterns, set budgets, and generate monthly reports.  
Built with CSV storage + OOP + modular architecture.

## Features
- Add, view, delete expenses
- Category-wise analytics
- Highest spending category detection
- Monthly budget setting and alerts
- Report generation (text file)
- CSV-based persistent storage

## Technologies Used
- Java 17+
- OOP principles
- CSV File Handling
- Collections (ArrayList, HashMap)

## Project Structure
SmartFinanceManager/
│
├── src/
│   ├── Main.java
│   ├── controllers/
│   │     └── MenuController.java
│   ├── models/
│   │     └── Expense.java
│   ├── services/
│   │     ├── ExpenseManager.java
│   │     ├── AnalyticsEngine.java
│   │     ├── BudgetManager.java
│   │     └── ReportGenerator.java
│   ├── storage/
│         └── StorageManager.java
│
├── data/
│     └── expenses.csv


## How to Run
1. Install JDK 11+  
2. Extract project folder  
3. Run:
javac Main.java
java Main

## Testing
- Add sample expenses  
- Validate CSV updates  
- Check analytics outputs  
- Generate report (data/report.txt)

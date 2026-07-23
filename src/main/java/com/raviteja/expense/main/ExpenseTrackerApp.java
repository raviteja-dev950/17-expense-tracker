package com.raviteja.expense.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.raviteja.expense.model.Expense;
import com.raviteja.expense.service.ExpenseService;

public class ExpenseTrackerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("      EXPENSE TRACKER SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Monthly Report");
            System.out.println("7. Category Report");
            System.out.println("8. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Expense expense = new Expense();

                System.out.print("Expense ID : ");
                expense.setExpenseId(sc.nextInt());
                sc.nextLine();

                System.out.print("Title : ");
                expense.setTitle(sc.nextLine());

                System.out.print("Category : ");
                expense.setCategory(sc.nextLine());

                System.out.print("Amount : ");
                expense.setAmount(sc.nextDouble());

                sc.nextLine();

                System.out.print("Expense Date (yyyy-mm-dd) : ");
                expense.setExpenseDate(Date.valueOf(sc.nextLine()));

                System.out.print("Payment Mode : ");
                expense.setPaymentMode(sc.nextLine());

                service.addExpense(expense);

                break;

            case 2:

                List<Expense> list = service.getAllExpenses();

                System.out.println("\n========== EXPENSE LIST ==========");

                for (Expense e : list) {

                    System.out.println("------------------------------");
                    System.out.println("ID       : " + e.getExpenseId());
                    System.out.println("Title    : " + e.getTitle());
                    System.out.println("Category : " + e.getCategory());
                    System.out.println("Amount   : " + e.getAmount());
                    System.out.println("Date     : " + e.getExpenseDate());
                    System.out.println("Payment  : " + e.getPaymentMode());

                }

                break;

            case 3:

                System.out.print("Expense ID : ");
                int id = sc.nextInt();

                Expense exp = service.searchExpense(id);

                if (exp != null) {

                    System.out.println("\nExpense Found");
                    System.out.println("-------------------------");
                    System.out.println("ID       : " + exp.getExpenseId());
                    System.out.println("Title    : " + exp.getTitle());
                    System.out.println("Category : " + exp.getCategory());
                    System.out.println("Amount   : " + exp.getAmount());
                    System.out.println("Date     : " + exp.getExpenseDate());
                    System.out.println("Payment  : " + exp.getPaymentMode());

                } else {

                    System.out.println("Expense Not Found.");

                }

                break;

            case 4:

                Expense update = new Expense();

                System.out.print("Expense ID : ");
                update.setExpenseId(sc.nextInt());

                sc.nextLine();

                System.out.print("Title : ");
                update.setTitle(sc.nextLine());

                System.out.print("Category : ");
                update.setCategory(sc.nextLine());

                System.out.print("Amount : ");
                update.setAmount(sc.nextDouble());

                sc.nextLine();

                System.out.print("Expense Date (yyyy-mm-dd) : ");
                update.setExpenseDate(Date.valueOf(sc.nextLine()));

                System.out.print("Payment Mode : ");
                update.setPaymentMode(sc.nextLine());

                service.updateExpense(update);

                break;

            case 5:

                System.out.print("Expense ID : ");
                service.deleteExpense(sc.nextInt());

                break;

            case 6:

                service.monthlyReport();

                break;

            case 7:

                service.categoryReport();

                break;

            case 8:

                System.out.println("Project 17 Done Bye!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");

            }

        }

    }

}
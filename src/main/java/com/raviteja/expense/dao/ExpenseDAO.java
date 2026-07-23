package com.raviteja.expense.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.raviteja.expense.model.Expense;
import com.raviteja.expense.util.DBConnection;

public class ExpenseDAO {

    public void addExpense(Expense expense) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO EXPENSES VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, expense.getExpenseId());
            ps.setString(2, expense.getTitle());
            ps.setString(3, expense.getCategory());
            ps.setDouble(4, expense.getAmount());
            ps.setDate(5, expense.getExpenseDate());
            ps.setString(6, expense.getPaymentMode());

            ps.executeUpdate();

            System.out.println("Expense Added Successfully.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Expense> getAllExpenses() {

        List<Expense> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM EXPENSES ORDER BY EXPENSE_ID");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Expense expense = new Expense();

                expense.setExpenseId(rs.getInt("EXPENSE_ID"));
                expense.setTitle(rs.getString("TITLE"));
                expense.setCategory(rs.getString("CATEGORY"));
                expense.setAmount(rs.getDouble("AMOUNT"));
                expense.setExpenseDate(rs.getDate("EXPENSE_DATE"));
                expense.setPaymentMode(rs.getString("PAYMENT_MODE"));

                list.add(expense);

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public Expense searchExpense(int id) {

        Expense expense = null;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM EXPENSES WHERE EXPENSE_ID=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                expense = new Expense();

                expense.setExpenseId(rs.getInt("EXPENSE_ID"));
                expense.setTitle(rs.getString("TITLE"));
                expense.setCategory(rs.getString("CATEGORY"));
                expense.setAmount(rs.getDouble("AMOUNT"));
                expense.setExpenseDate(rs.getDate("EXPENSE_DATE"));
                expense.setPaymentMode(rs.getString("PAYMENT_MODE"));

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expense;

    }

    public void updateExpense(Expense expense) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE EXPENSES SET TITLE=?,CATEGORY=?,AMOUNT=?,EXPENSE_DATE=?,PAYMENT_MODE=? WHERE EXPENSE_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, expense.getExpenseDate());
            ps.setString(5, expense.getPaymentMode());
            ps.setInt(6, expense.getExpenseId());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Expense Updated Successfully.");
            else
                System.out.println("Expense Not Found.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteExpense(int id) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("DELETE FROM EXPENSES WHERE EXPENSE_ID=?");

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Expense Deleted Successfully.");
            else
                System.out.println("Expense Not Found.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void monthlyReport() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT TO_CHAR(EXPENSE_DATE,'MON-YYYY') MONTH, SUM(AMOUNT) TOTAL FROM EXPENSES GROUP BY TO_CHAR(EXPENSE_DATE,'MON-YYYY')");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n======= MONTHLY REPORT =======");

            while (rs.next()) {

                System.out.println("Month : " + rs.getString("MONTH"));
                System.out.println("Total : " + rs.getDouble("TOTAL"));
                System.out.println("----------------------------");

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void categoryReport() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT CATEGORY,SUM(AMOUNT) TOTAL FROM EXPENSES GROUP BY CATEGORY");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n======= CATEGORY REPORT =======");

            while (rs.next()) {

                System.out.println("Category : " + rs.getString("CATEGORY"));
                System.out.println("Total    : " + rs.getDouble("TOTAL"));
                System.out.println("----------------------------");

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
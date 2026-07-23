package com.raviteja.expense.model;

import java.sql.Date;

public class Expense {

    private int expenseId;
    private String title;
    private String category;
    private double amount;
    private Date expenseDate;
    private String paymentMode;

    public Expense() {
    }

    public Expense(int expenseId, String title, String category,
                   double amount, Date expenseDate,
                   String paymentMode) {

        this.expenseId = expenseId;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.paymentMode = paymentMode;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

}
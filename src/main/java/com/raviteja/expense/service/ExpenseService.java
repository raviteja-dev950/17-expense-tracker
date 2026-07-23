package com.raviteja.expense.service;

import java.util.List;

import com.raviteja.expense.dao.ExpenseDAO;
import com.raviteja.expense.model.Expense;

public class ExpenseService {

	private ExpenseDAO dao = new ExpenseDAO();

	public void addExpense(Expense expense) {
		dao.addExpense(expense);
	}

	public List<Expense> getAllExpenses() {
		return dao.getAllExpenses();
	}

	public Expense searchExpense(int id) {
		return dao.searchExpense(id);
	}

	public void updateExpense(Expense expense) {
		dao.updateExpense(expense);
	}

	public void deleteExpense(int id) {
		dao.deleteExpense(id);
	}

	public void monthlyReport() {
		dao.monthlyReport();
	}

	public void categoryReport() {
		dao.categoryReport();
	}
}
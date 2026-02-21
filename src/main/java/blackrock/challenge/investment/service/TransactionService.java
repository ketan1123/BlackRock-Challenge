package blackrock.challenge.investment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import blackrock.challenge.investment.dto.Expenses;
import blackrock.challenge.investment.dto.ReturnRequest;
import blackrock.challenge.investment.dto.ReturnResponse;
import blackrock.challenge.investment.dto.SavingsByDate;
import blackrock.challenge.investment.dto.Transactions;

@Service
public class TransactionService {

	private static final double NPS_RATE = 0.0711;
	private static final double INDEX_RATE = 0.1449;

	public List<Transactions> parseTransactions(List<Expenses> expenseList) {

		List<Transactions> transactionList = new ArrayList<Transactions>();

		for (Expenses expense : expenseList) {
			Transactions trans = new Transactions();
			trans.setDate(expense.getDate());
			trans.setAmount(expense.getAmount());
			trans.setCeiling(this.calculateCeiling(expense.getAmount()));
			trans.setRemanent(this.calculateRemantant(trans.getCeiling(), trans.getAmount()));
			transactionList.add(trans);
		}

		return transactionList;
	}

	public Double calculateCeiling(Double amt) {
		Double amount = (amt / 100) * 100 + 100;
		return amount;
	}

	public Double calculateRemantant(Double ceiling, Double amount) {
		Double amt = ceiling - amount;
		return amt;
	}

	public ReturnResponse calculateNPS(ReturnRequest request) {
		return processReturns(request, NPS_RATE, true);
	}

	public ReturnResponse calculateIndex(ReturnRequest request) {
		return processReturns(request, INDEX_RATE, false);
	}

	private ReturnResponse processReturns(ReturnRequest request, double rate, boolean isNps) {

		int years = request.getAge() < 60 ? 60 - request.getAge() : 5;

		double totalAmount = 0;
		double totalCeiling = 0;

		for (Transactions t : request.getTransactions()) {
			totalAmount += t.getRemanent();
			totalCeiling += t.getCeiling();
		}

		List<SavingsByDate> savings = new ArrayList<>();

		for (var k : request.getK()) {

			double periodAmount = request.getTransactions().stream()
					.filter(t -> !t.getDate().isBefore(k.getStart()) && !t.getDate().isAfter(k.getEnd()))
					.mapToDouble(Transactions::getRemanent).sum();

			double finalAmount = compound(periodAmount, rate, years);
			double realAmount = adjustInflation(finalAmount, request.getInflation(), years);

			double profit = realAmount - periodAmount;

			double taxBenefit = 0;

			if (isNps) {
				double annualIncome = request.getWage() * 12;
				double deduction = Math.min(periodAmount, Math.min(annualIncome * 0.10, 200000));

				double taxBefore = calculateTax(annualIncome);
				double taxAfter = calculateTax(annualIncome - deduction);
				taxBenefit = taxBefore - taxAfter;
			}

			savings.add(new SavingsByDate(k.getStart(), k.getEnd(), periodAmount, profit, taxBenefit));
		}

		return new ReturnResponse(totalAmount, totalCeiling, savings);
	}

	private double compound(double principal, double rate, int years) {
		return principal * Math.pow((1 + rate), years);
	}

	private double adjustInflation(double amount, double inflation, int years) {
		return amount / Math.pow((1 + inflation), years);
	}

	private double calculateTax(double income) {

		if (income <= 700000)
			return 0;

		if (income <= 1000000)
			return (income - 700000) * 0.10;

		if (income <= 1200000)
			return 300000 * 0.10 + (income - 1000000) * 0.15;

		if (income <= 1500000)
			return 300000 * 0.10 + 200000 * 0.15 + (income - 1200000) * 0.20;

		return 300000 * 0.10 + 200000 * 0.15 + 300000 * 0.20 + (income - 1500000) * 0.30;
	}
}

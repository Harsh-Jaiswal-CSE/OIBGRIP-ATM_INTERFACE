import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	public double calCurrentWithdraw(double amount) {
		currentBalance = (currentBalance - amount);
		return currentBalance;
	}
	public double calSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	public double calCurrentDeposit(double amount) {
		currentBalance = (currentBalance + amount);
		return currentBalance;
	}
	public double calSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
	
	public double calSavingTransfer(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	public double calCurrentTransfer(double amount) {
		currentBalance = (currentBalance + amount);
		return currentBalance;
	}
	public void getCurrentWithdrawInput() {
		System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
		System.out.print("Amount you want to withdraw from Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance - amount) >= 0) {
			calCurrentWithdraw(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			calSavingWithdraw(amount);
			System.out.println("New Saving Account balance: " + savingBalance + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	public void getCurrentDepositInput() {
		System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
		System.out.print("Amount you want to deposit from Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance + amount) >= 0) {
			calCurrentDeposit(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to deposit from Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance + amount) >= 0) {
			calSavingDeposit(amount);
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	public void getSavingTransferInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to transfer from Saving Account: ");
		double amount = input.nextDouble();
		if (savingBalance >= 0) {
			calSavingTransfer(amount);
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
			calCurrentTransfer(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}

	}
	private int customerNumber;
	private int pinNumber;
	private double currentBalance = 50000;
	private double savingBalance = 500000;
}

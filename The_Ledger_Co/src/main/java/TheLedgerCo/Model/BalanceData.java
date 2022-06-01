package TheLedgerCo.Model;

import java.util.ArrayList;

public class BalanceData {
	
	private String bankName, borrowerName;
	private Integer EMI_No;
	private Float balancePending;
	
	public Float getBalancePending() {
		return balancePending;
	}
	public void setBalancePending(Float balancePending) {
		this.balancePending = balancePending;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public Integer getEMI_No() {
		return EMI_No;
	}
	public void setEMI_No(Integer eMI_No) {
		EMI_No = eMI_No;
	}
	@Override
	public String toString() {
		return "BalanceData [bankName=" + bankName + ", borrowerName=" + borrowerName + ", EMI_No=" + EMI_No
				+ ", balancePending=" + balancePending + "]";
	}
	
	public ArrayList<ArrayList<String>> findBalance(ArrayList<BalanceData> balances, ArrayList<PaymentData> payments, ArrayList<LoanData> loans){

		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		
		for (BalanceData balance : balances) {
			
			PaymentData userPaymentData = new PaymentData();
			LoanData userLoanData = new LoanData();
			ArrayList<String> userOutput = new ArrayList<String>();
			
			userPaymentData = userPaymentData.fetchPaymentData(payments, balance.getBankName() , balance.getBorrowerName());
			userLoanData = userLoanData.fetchLoanData(loans, balance.getBankName(), balance.getBorrowerName());

			
			userOutput.add(userLoanData.getBankName());
			userOutput.add(userLoanData.getBorrowerName());
			
			Double EMI_Paid;
			
			EMI_Paid = userLoanData.getEMI_Amount()*balance.getEMI_No();
			
			if(userPaymentData!=null) {
				if((userPaymentData.getEMI_No()<=balance.getEMI_No())&&(userPaymentData.getLumpSumAmount()!=null))			
					EMI_Paid+=userPaymentData.getLumpSumAmount();
			}
			Integer intEMI_Paid = EMI_Paid.intValue();
			userOutput.add(intEMI_Paid.toString());
			
			Integer EMIs_left;
			EMIs_left = (int) Math.ceil((userLoanData.getPrincipal()+(userLoanData.getPrincipal()*userLoanData.getNumOfYears()*(userLoanData.getInterestRate()/100))-EMI_Paid)/userLoanData.getEMI_Amount());

			userOutput.add(EMIs_left.toString());
			output.add((ArrayList<String>) userOutput.clone());

			userOutput.clear();
		}
		return output;
	}
	
	
	
}

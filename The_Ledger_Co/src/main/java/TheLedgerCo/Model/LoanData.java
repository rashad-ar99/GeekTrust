package TheLedgerCo.Model;

import java.util.ArrayList;

public class LoanData {
	
	private String bankName, borrowerName;
	private Double principal, interestRate, EMI_Amount;
	private Integer numOfYears;
	
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
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Integer getNumOfYears() {
		return numOfYears;
	}
	public void setNumOfYears(Integer numOfYears) {
		this.numOfYears = numOfYears;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public Double getEMI_Amount() {
		return EMI_Amount;
	}
	public void setEMI_Amount(Double eMI_Amount) {
		EMI_Amount = eMI_Amount;
	}
	@Override
	public String toString() {
		return "LoanData [bankName=" + bankName + ", borrowerName=" + borrowerName + ", principal=" + principal
				+ ", interestRate=" + interestRate + ", EMI_Amount=" + EMI_Amount + ", numOfYears=" + numOfYears + "]";
	}
	
	public LoanData fetchLoanData(ArrayList<LoanData> loans, String bankName, String borrowerName) {
		
		for (LoanData loanData : loans) {
			if(loanData.getBorrowerName().equals(borrowerName)&&loanData.getBankName().equals(bankName))
				return loanData;
		}
		return null;
	}
	
	
}

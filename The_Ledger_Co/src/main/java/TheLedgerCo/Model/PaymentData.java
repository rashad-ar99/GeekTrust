package TheLedgerCo.Model;

import java.util.ArrayList;

public class PaymentData {
	
	private String bankName, borrowerName;
	private Double lumpSumAmount;
	private Integer EMI_No;
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
	public Double getLumpSumAmount() {
		return lumpSumAmount;
	}
	public void setLumpSumAmount(Double lumpSumAmount) {
		this.lumpSumAmount = lumpSumAmount;
	}
	public Integer getEMI_No() {
		return EMI_No;
	}
	public void setEMI_No(Integer eMI_No) {
		EMI_No = eMI_No;
	}
	@Override
	public String toString() {
		return "PaymentData [bankName=" + bankName + ", borrowerName=" + borrowerName + ", lumpSumAmount="
				+ lumpSumAmount + ", EMI_No=" + EMI_No + "]";
	}
	
	public PaymentData fetchPaymentData(ArrayList<PaymentData> payments, String bankName, String borrowerName) {
			
			for (PaymentData payment : payments) {
				if(payment.getBorrowerName().equals(borrowerName)&&payment.getBankName().equals(bankName))
					return payment;
			}
			return null;
		}
}

package TheLedgerCo.Service;

import java.util.ArrayList;

import TheLedgerCo.Model.BalanceData;
import TheLedgerCo.Model.LoanData;
import TheLedgerCo.Model.PaymentData;

public class FindBalance {
	
	public ArrayList<ArrayList<String>> findBalance(String[] args) {
			
			FindBalance balance = new FindBalance();
	    	
	    	ArrayList<PaymentData> payments = new ArrayList<>(); 
	    	ArrayList<BalanceData> balances = new ArrayList<>(); ;
	    	ArrayList<LoanData> loans = new ArrayList<>();
	    	
	    	ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
	    	
	    	BalanceData getBalances = new BalanceData();
	    	
	    	input = balance.sortDataIntoArrayList(args);
	    	loans = balance.sortLoanData(input);
	    	payments = balance.sortPaymentData(input);    
	    	balances = balance.sortBalanceData(input);
	    	
	    	return getBalances.findBalance(balances,payments,loans);
	    		
		}
	public ArrayList<ArrayList<String>> sortDataIntoArrayList(String[] args) {

    	ArrayList<ArrayList<String>> input = new ArrayList<>();
    	ArrayList<String> temp = new ArrayList<String>();
    	int i=0;
    	
    	for(i=0;i<args.length;i++){
    		temp.add(args[i]);
    		if(i<args.length-1) {
	    		if(args[i+1].equalsIgnoreCase("LOAN")||args[i+1].equalsIgnoreCase("BALANCE")||args[i+1].equalsIgnoreCase("PAYMENT")){
	    			input.add((ArrayList<String>) temp.clone());
	    			temp.clear();
	    			}
    		}
    		else if(i==(args.length-1)) {
    			input.add((ArrayList<String>) temp.clone());
    			temp.clear();
    		}
    	}

    	return input;
    }
    
    public ArrayList<PaymentData> sortPaymentData(ArrayList<ArrayList<String>> input) {
    	
    	ArrayList<PaymentData> payments = new ArrayList<PaymentData>();
    	for(int i=0;i<input.size();i++){
        	PaymentData payment = new PaymentData();
    		if(input.get(i).get(0).equalsIgnoreCase("PAYMENT")){
    			payment.setBankName(input.get(i).get(1));
    			payment.setBorrowerName(input.get(i).get(2));
    			payment.setLumpSumAmount(Double.valueOf(input.get(i).get(3)));
    			payment.setEMI_No(Integer.valueOf(input.get(i).get(4)));
    			payments.add(payment);
    		}
    	}

    	return payments;
    }
    
    public ArrayList<BalanceData> sortBalanceData(ArrayList<ArrayList<String>> input) {
    	
    	ArrayList<BalanceData> balances = new ArrayList<BalanceData>();
    	for(int i=0;i<input.size();i++){
    		BalanceData balance = new BalanceData();
    		if(input.get(i).get(0).equalsIgnoreCase("BALANCE")){
    			balance.setBankName(input.get(i).get(1));
    			balance.setBorrowerName(input.get(i).get(2));
    			balance.setEMI_No(Integer.valueOf(input.get(i).get(3)));
    			balances.add(balance);
    		}
    	}
    	return balances;
    }
    
    public ArrayList<LoanData> sortLoanData(ArrayList<ArrayList<String>> input) {
    	
    	ArrayList<LoanData> loans = new ArrayList<LoanData>();
    	for(int i=0;i<input.size();i++){
    		LoanData loan = new LoanData();
    		if(input.get(i).get(0).equalsIgnoreCase("LOAN")){
    			loan.setBankName(input.get(i).get(1));
    			loan.setBorrowerName(input.get(i).get(2));
    			loan.setPrincipal(Double.valueOf(input.get(i).get(3)));
    			loan.setNumOfYears((Integer.valueOf(input.get(i).get(4))));
    			loan.setInterestRate(Double.valueOf(input.get(i).get(5)));
    			loan.setEMI_Amount(Math.ceil(((loan.getPrincipal()+(loan.getPrincipal()*loan.getNumOfYears()*(loan.getInterestRate()/100)))/(loan.getNumOfYears()*12))));
    			loans.add(loan);
    		}
    	}
    	return loans;
    }
}

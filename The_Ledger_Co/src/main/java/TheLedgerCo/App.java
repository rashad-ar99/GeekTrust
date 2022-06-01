package TheLedgerCo;

import java.util.ArrayList;

import TheLedgerCo.Service.FindBalance;

public class App 
{
    public static void main( String[] args )
    {
    	FindBalance balance = new FindBalance();
    	
    	for(ArrayList<String> userOutput:balance.findBalance(args)) {
    		for (String userBalance : userOutput) {
				System.out.print(userBalance+" ");
			}
    		System.out.println();
    	}
    }
}

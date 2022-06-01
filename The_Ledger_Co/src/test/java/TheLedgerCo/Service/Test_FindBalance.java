package TheLedgerCo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Test_FindBalance {
	
	FindBalance balance = new FindBalance();
	
	@Test
	public void testfindBalance() {
		String str = "LOAN IDIDI Dale 10000 5 4\r\n"
				+ " LOAN MBI Harry 2000 2 2\r\n"
				+ " BALANCE IDIDI Dale 5\r\n"
				+ " BALANCE IDIDI Dale 40\r\n"
				+ " BALANCE MBI Harry 12\r\n"
				+ " BALANCE MBI Harry 0";
		
		String[] args = str.split("\\s+");
		
		str = "IDIDI Dale 1000.0 55 \r\n"
				+ " IDIDI Dale 8000.0 20 \r\n"
				+ " MBI Harry 1044.0 12 \r\n"
				+ " MBI Harry 0.0 24 \r\n";
		
		String[] outputString = str.split("\\s+");
		
		ArrayList<String> desiredOutput = new ArrayList<String>();
		ArrayList<ArrayList<String>> functionOutput = new ArrayList<ArrayList<String>>();
		ArrayList<String> actualOutput = new ArrayList<String>();
		
		desiredOutput.addAll(Arrays.asList(outputString));		
		functionOutput = balance.findBalance(args);
		
		for(int i=0;i<functionOutput.size();i++){
			actualOutput.addAll(functionOutput.get(i));
		}
		
		System.out.println(actualOutput);

		assertEquals( desiredOutput, actualOutput);

	}
}

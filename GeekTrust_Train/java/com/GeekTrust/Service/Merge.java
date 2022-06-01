package com.GeekTrust.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.GeekTrust.Model.Train;

public class Merge {

	public static ArrayList<String> MergeTrains(Train A, Train B, HashMap<String, Integer> OrderofBogies) {
		
		Train AB = new Train();
		ArrayList<String> MergedTrain = new ArrayList<String>();
		
		//Removing all stops before HYB.
		A.getCompartment().removeIf(stop->(stop.equals("SLM")||stop.equals("BLR")||stop.equals("KRN")||stop.equals("ENGINE")||stop.equals("TRAIN_A")));
		B.getCompartment().removeIf(stop->(stop.equals("SRR")||stop.equals("MAQ")||stop.equals("MAO")||stop.equals("PNE")||stop.equals("ENGINE")||stop.equals("TRAIN_B")));
		 	
		//Adding train A and B compartments to merged train.
		MergedTrain.addAll(A.getCompartment());
		MergedTrain.addAll(B.getCompartment());
		
		//Printing arrival trains A and B.
		
		A.getCompartment().add(0, "TRAIN_A");
		A.getCompartment().add(1, "ENGINE");
		
		B.getCompartment().add(0, "TRAIN_B");
		B.getCompartment().add(1, "ENGINE");
		
		System.out.print("\nARRIVAL ");
		for (String string : A.getCompartment()) {
			System.out.print(string+" ");
		}
		System.out.print("\nARRIVAL ");
		for (String string : B.getCompartment()) {
			System.out.print(string+" ");
		}
		
		MergedTrain.removeIf(stop->(stop.equals("HYB")));
		
		//To check for journey ended.
		if(MergedTrain.size()==3){
			System.out.print("\n\nJOURNEY_ENDED");
			System.exit(0);
		}		
		
		//Adding ENGINE to train AB.
		AB.getCompartment().add(0,"ENGINE");
		AB.getCompartment().add(0,"ENGINE");
		AB.getCompartment().add(0,"TRAIN_AB");
		AB.getCompartment().addAll(MergedTrain);
		
		return SortBogies(AB, MergedTrain, OrderofBogies);
	}
	
	public static ArrayList<String> SortBogies(Train AB, ArrayList<String> MergedTrain, HashMap<String, Integer> OrderofBogies) {

		
//		Adds the order of each stop to the stops in Train AB.
//		i=3 as process only starts from 3rd element as first 3 are fixed.
		for (int i=3;i<AB.getCompartment().size();i++) {
			Integer Distance = OrderofBogies.get(AB.getCompartment().get(i));
			AB.getCompartment().set(i, Distance.toString().concat(AB.getCompartment().get(i)));
		}
		
		String temp;
		
//		Orders the stops according to the order of each stop.
//		i=3 as process only starts from 3rd element as first 3 are fixed.
		for(int i=3;i<AB.getCompartment().size();i++) {
			for(int j=i;j<AB.getCompartment().size();j++) {
				if(AB.getCompartment().get(i).charAt(0)<AB.getCompartment().get(j).charAt(0))
				{
					temp = AB.getCompartment().get(i);
					AB.getCompartment().set(i,AB.getCompartment().get(j));
					AB.getCompartment().set(j,temp);
				}
			}
			//Removes the order from the stop names.
			AB.getCompartment().set(i, AB.getCompartment().get(i).substring(1));
		}
		System.out.print("\nDEPARTURE ");
		return AB.getCompartment();		
	}
}
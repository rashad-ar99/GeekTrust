package com.GeekTrust.Main;

import java.util.ArrayList;
import java.util.HashMap;

import com.GeekTrust.Model.Bogie;
import com.GeekTrust.Model.Train;
import com.GeekTrust.Service.Merge;

public class Main {

public static void main(String[] args) {
		
		Train TrainA = new Train();
		Train TrainB = new Train();
		ArrayList<String> Bogies = new ArrayList<String>();
		
		HashMap<String, Integer> OrderofBogies = new HashMap<>();
		
		Bogie.initializeData(OrderofBogies);
		
		
		int i=0;
		
//		Putting Train A bogies into TrainA object.
		while(!(args[i].equalsIgnoreCase("TRAIN_B"))){
			Bogies.add(args[i]);
			i++;
		}
		
		TrainA.getCompartment().addAll(Bogies);
		Bogies.clear();
		
//		Putting Train B bogies into TrainB object.
		while(i<args.length){
			Bogies.add(args[i]);
			i++;
		}
		
		TrainB.getCompartment().addAll(Bogies);
		Bogies.clear();

//		Print merged train.
		for (String string : Merge.MergeTrains(TrainA, TrainB, OrderofBogies)) {
			System.out.print(string+" ");
		}
		
		
	}
}

package com.GeekTrust.Model;

import java.util.HashMap;

public class Bogie {
	
	private String StopName;
	private Integer DistanceFromStart;
	
	public String getStopName() {
		return StopName;
	}
	public void setStopName(String stopName) {
		StopName = stopName;
	}
	public Integer getDistanceFromStart() {
		return DistanceFromStart;
	}
	public void setDistanceFromStart(Integer distanceFromStart) {
		DistanceFromStart = distanceFromStart;
	}
	public Bogie(String stopName, Integer distanceFromStart) {
		super();
		StopName = stopName;
		DistanceFromStart = distanceFromStart;
	}
	public static HashMap<String, Integer> initializeData(HashMap<String, Integer> path)
	{
		//Initializes path with stops in ascending order of distance from HYB.
		path.put("HYB",0);	//Distance: 1200
		path.put("NGP",1);	//Distance: 1600
		path.put("ITJ",2);	//Distance: 1900
		path.put("BPL",3);	//Distance: 2000
		path.put("AGA",4);	//Distance: 2500
		path.put("NDL",5);	//Distance: 2700
		path.put("PTA",6);	//Distance: 3800
		path.put("NJP",7);	//Distance: 4200
		path.put("GHY",8);	//Distance: 4700
		return path;
	}
}
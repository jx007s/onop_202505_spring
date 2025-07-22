package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class StudList {

	List<Stud> studs;
	
	int totAvg, avgAvg;
	
	public void calc() {
		int totSum = 0, avgSum = 0;
		for (Stud st : studs) {
			st.calc();
			totSum += st.tot;
			avgSum += st.avg;
		}
		
		totAvg = totSum/studs.size();
		avgAvg = avgSum/studs.size();
		
	}
}

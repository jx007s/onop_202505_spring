package aaa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Stud {

	String name;
	int kor, eng, mat,tot,avg;
	public Stud(String name, int kor, int eng, int mat) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		calc();
	}
	
	void calc() {
		tot = kor + eng + mat;
		avg = tot / 3;
	}
	
}

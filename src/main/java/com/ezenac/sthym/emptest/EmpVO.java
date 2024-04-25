package com.ezenac.sthym.emptest;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.ezenac.sthym.test.Emp;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude= {"ename","sal","hiredate"})
public class EmpVO implements Serializable{

	@NonNull private int empno;
	private String ename;
	private int sal;
	private String hiredate;
	/*
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private LocalDate hiredate;   //java.sql.Date.valueOf(hiredate);
	*/
	public EmpVO(int empno) {
		super();
		this.empno = empno;
	}	
	

}

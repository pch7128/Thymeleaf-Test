package com.ezenac.sthym.emptest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpSvc {

	@Autowired
	private FileDAO dao;
	
	public List<EmpVO> getList(){
		return dao.getList();
	}
	
	public boolean addEmp(EmpVO e) {
		return dao.saveEmp(e);
	}
	
	public EmpVO getEmp(int empno) {
		
		return dao.getEmp(empno);
	}
	
	public boolean deleteEmp(int empno) {
		return dao.empDeleted(empno);
	}
	
	public boolean editEmp(EmpVO e) {
		return dao.empEdit(e);
	}
}

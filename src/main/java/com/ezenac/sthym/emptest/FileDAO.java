package com.ezenac.sthym.emptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	private String fpath="/Users/eeeun/Documents/test/emps.ser";
	
	
	public List<EmpVO> getList(){
		
		List<EmpVO> elist= null;
		File f = new File(fpath);
		
		if(!f.exists()) {
			elist= new ArrayList<EmpVO>();
		} else {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fpath));
				elist=(List<EmpVO>)ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return elist;
	}
	
	public boolean saveEmp(EmpVO e) {
		
		List<EmpVO> elist=getList();
		elist.add(e);
		return addFile(elist);
	}

	public boolean addFile(List<EmpVO> elist) {
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fpath));
			oos.writeObject(elist);
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public EmpVO getEmp(int empno) {
		
		List<EmpVO> elist=getList();
		EmpVO e = new EmpVO(empno);
		if(elist.contains(e)) {
			EmpVO emp=elist.get(elist.indexOf(e));
			return emp;
		}
		
		return null;
	}
	
	public boolean empDeleted(int empno) {
		
		List<EmpVO> elist=getList();
		EmpVO e = new EmpVO(empno);
		
		if(elist.contains(e)) {	
			elist.remove(elist.indexOf(e));
			return addFile(elist);
		}
		return false;
	}
	
	public boolean empEdit(EmpVO e) {
		List<EmpVO> elist=getList();
		if(elist.contains(e)) {
			elist.get(elist.indexOf(e)).setEname(e.getEname());
			elist.get(elist.indexOf(e)).setSal(e.getSal());
			return addFile(elist);
		}
		return false;
	}
}

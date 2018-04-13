package com.core.Collection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Student{
	private String fname;
	private String lname;
	private Date date;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}


public class Collection_Demo {
	
	public static void main(String args[]) {
		
		Map<String,Student> studentMap = new HashMap<String, Student>();
		
		for (int i = 40; i < 43; i++) {
			Student student = new Student();
			student.setFname(i+"pavan");
			student.setLname(i+"kumar");
			student.setDate(new Date());
			studentMap.put("student"+i, student);
		}
		
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setFname(i+"pavan");
			student.setLname(i+"kumar");
			student.setDate(new Date());
			studentMap.put("student"+i, student);
		}
		
		
		for (int i = 20; i < 23; i++) {
			Student student = new Student();
			student.setFname(i+"pavan");
			student.setLname(i+"kumar");
			student.setDate(new Date());
			studentMap.put("student"+i, student);
		}
		
		for (Entry<String, Student> data : studentMap.entrySet()) {
			System.out.println("data "+data.getKey()+" - "+"Student F name "+data.getValue().getFname());
		}
	}
}

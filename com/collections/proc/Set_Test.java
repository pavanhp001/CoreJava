package com.collections.proc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Set_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Emp> empList = new ArrayList<Emp>();
		
		Set<Emp> empSet1 = new HashSet<Emp>();
		//Set<Emp> empSet = new TreeSet<Emp>();  // Emp class should impliments java.lang.Comparable or Comparator interface.
		
		Set<Emp> empSet = new TreeSet<Emp>(new Comparator<Emp>() {
			public int compare(Emp e1,Emp e2){
				return e1.getSal() - e2.getSal();
			}
		});
		Emp e1 = new Emp("pavan", 100, "developer1");
		Emp e2 = new Emp("pavan", 600, "developer2");
		Emp e3 = new Emp("pavan", 300, "developer3");
		Emp e4 = new Emp("pavan", 200, "developer4");
		Emp e5 = new Emp("pavan", 500, "developer5");
		
		empList.add(e1);empList.add(e2);empList.add(e3);empList.add(e4);empList.add(e5);
		Collections.sort(empList, new Comparator<Emp>() {
			public int compare(Emp e1, Emp e2){
				return e1.getSal() - e2.getSal(); // assending order
				//return e2.getSal() - e1.getSal();    // desending order
				//return e1.getSal().compareTo(e2.getSal());  - get compile error becouse compareTo() doesnt have in Int primitive type
			}
		});
		for (Emp emp : empList) {
			System.out.println("empList data: "+emp );
		}
		
		empSet.add(e1);empSet.add(e2);empSet.add(e3);empSet.add(e4);empSet.add(e5);
		
		//List<Emp> arrayList = new ArrayList<Emp>(empSet);
		//Collections.sort(arrayList, new MyComparator());
		
		
		System.out.println("=======================");
		/*for (Emp emp : arrayList) {
			System.out.println("arrayList data: "+emp );
		}*/
		//System.out.println("empList data: "+Arrays.toString(empList) );
		
		System.out.println("=======================");
		for (Emp emp : empSet) {
			System.out.println("empSet data: "+emp );
		}
	}
}
class Emp{
	
	private String name;
	private int sal;
	private String job;
	
	
	/**
	 * @param name
	 * @param sal
	 * @param job
	 */
	public Emp(String name, int sal, String job) {
		super();
		this.name = name;
		this.sal = sal;
		this.job = job;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emp [name=" + name + ", sal=" + sal + ", job=" + job + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sal;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}
}

class MyComparator implements Comparator<Emp>{
	public int compare(Emp e1, Emp e2){
		return e1.getSal() - e2.getSal(); // assending order
	}
}

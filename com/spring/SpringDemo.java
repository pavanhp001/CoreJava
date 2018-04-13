package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");  
		   // BeanFactory factory=new XmlBeanFactory(resource);  
		      
		    Student student=(Student)context.getBean("studentbean");  
		    student.displayInfo();  
		    student.displayNames(); 
	}

}

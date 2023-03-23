package com.web.test;

import java.util.Scanner;

import org.hibernate.Session;

import com.web.model.BankDetails;
import com.web.model.Employee;
import com.web.utility.HibernateUtil;

public class Main {

	public static void setEmpInfo()
	{
		Scanner sc=new Scanner(System.in);
		Session session=HibernateUtil.getSessionFactory().openSession();
		BankDetails bankdetails=new BankDetails();
		System.out.println("Enter EMPLOYEE Nd BANK Details");
		System.out.print(" Account Number     = ");
		bankdetails.setAccountNumber(sc.nextLong());
		System.out.print(" Bank Name          = ");
		bankdetails.setBankName(sc.next());
		
		System.out.print(" Bank IFSC Code     = ");
		bankdetails.setBankIFSC_Code(sc.next());
		
		System.out.print(" Branch Name        =");
		bankdetails.setBranchName(sc.next());
		
		Employee emp=new Employee();
		System.out.print(" Employee Name      = ");
		emp.setEmpName(sc.next());
		System.out.print(" Contact No         = ");
		emp.setContactNo(sc.nextLong());
		emp.setBankDetails(bankdetails);
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("**** SuccessFully Inserted ****");
		System.out.println("------------------------------------------");
	}
	
	public static void getEmpInfo()
	{
		Scanner sc=new Scanner(System.in);
		Session session=HibernateUtil.getSessionFactory().openSession();
		 System.out.print("Enter Employee Id U want to Display = ");
    	 int eid=sc.nextInt();
    	
		Employee emp=session.get(Employee.class,eid);
		System.out.println(" EMPLOYEE ID         = "+emp.getEmpId());
		System.out.println(" EMPLOYEE NAME       = "+emp.getEmpName());
		System.out.println(" CONTACTNO			 = "+emp.getContactNo());
		System.out.println(" ACCOUNT NUMBER      = "+emp.getBankDetails().getAccountNumber());
		System.out.println(" BANK NAME           = "+emp.getBankDetails().getBankName());
		System.out.println(" BANK IFSC CODE      = "+emp.getBankDetails().getBankIFSC_Code());
		System.out.println(" BRANCH NAME         = "+emp.getBankDetails().getBranchName());
		System.out.println("------------------------------------------");
		
	}
	
	public static void loadEmpInfo()
	{
		Scanner sc=new Scanner(System.in);
		Session session=HibernateUtil.getSessionFactory().openSession();
		 System.out.print("Enter Employee Id U want to Display = ");
    	 int eid=sc.nextInt();
    	
		Employee emp=session.load(Employee.class,eid);
		System.out.println(" EMPLOYEE ID         = "+emp.getEmpId());
		System.out.println(" EMPLOYEE NAME       = "+emp.getEmpName());
		System.out.println(" CONTACTNO   		 = "+emp.getContactNo());
		System.out.println(" ACCOUNT NUMBER      = "+emp.getBankDetails().getAccountNumber());
		System.out.println(" BANK NAME           = "+emp.getBankDetails().getBankName());
		System.out.println(" BANK IFSC CODE      = "+emp.getBankDetails().getBankIFSC_Code());
		System.out.println(" BRANCH NAME         = "+emp.getBankDetails().getBranchName());
		System.out.println("------------------------------------------");
			}
	
	public static void updateEmp()
	{
		Scanner sc=new Scanner(System.in);
		Session session=HibernateUtil.getSessionFactory().openSession();
		 System.out.print("Enter Employee Id U want to Update = ");
    	 int eid=sc.nextInt();


    	 Employee emp=session.get(Employee.class,eid);
    	 System.out.println("1=Employee Name");
    	 System.out.println("2=Contact No ");
    	 System.out.println("3=Bank Name");
    	 System.out.println("4=Bank IFSC code");
    	 System.out.println("5=Branch Name");
    	 System.out.println("6=Account Number");
    	 System.out.println("Enter choice for Update Records = ");
    	int ch=sc.nextInt();
    	 switch(ch)
    	 {
    	 case 1:
    		 System.out.print("Enter New Employee Name = ");
    		 emp.setEmpName(sc.next());
    		 break;
    	 
    	 case 2:
    		 System.out.print("Enter New Contact No = ");
    		 emp.setContactNo(sc.nextLong());
    		 break;
    	
    	 case 3: 
    		 System.out.print("Enter New Bank Name  = ");
    		 emp.getBankDetails().setBankName(sc.next());
    		 break;
    	
    	 case 4:
    		 System.out.print("Enter New Branch Name = ");
    		 emp.getBankDetails().setBranchName(sc.next());
    		 break;
    		 
    	 case 5:
    		 System.out.print("Enter New Account Number = ");
    		 emp.getBankDetails().setAccountNumber(sc.nextLong());
    		 break;
    		  
    	 case 6:
    		 System.out.print("Enter New Bank IFSC Code = ");
    		 emp.getBankDetails().setBankIFSC_Code(sc.next());
    		 break;
    	 }
    	 session.update(emp);
    	 session.beginTransaction().commit();
    	 System.out.println("**** SuccessFully Udated ****");
    	 System.out.println("------------------------------------------");

	}
	public static void deleteEmp()
	{
		Scanner sc=new Scanner(System.in);
		Session session=HibernateUtil.getSessionFactory().openSession();
		 System.out.print("Enter Employee Id U want to Display = ");
    	 int eid=sc.nextInt();
    	
    	 Employee emp=session.get(Employee.class,eid);
    	 session.delete(emp);
    	 session.beginTransaction().commit();
    	 System.out.println("**** SuccessFully Deleted ****");
    	 System.out.println("------------------------------------------");
	}
	public static void main(String[] args) {
		Main main=new Main();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println();
	System.out.println("*********EMPLOYEE DETAILS *******");
		System.out.println("1=Insert Records ");
		System.out.println("2=Display Records using get()");
		System.out.println("3=Display Records using load()");
		System.out.println("4=Update Records ");
		System.out.println("5=Delete Records ");
		System.out.print("Enter Choice : ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:	main.setEmpInfo();
		break;
		
		case 2: main.getEmpInfo();
		break;
		
		case 3: main.loadEmpInfo();
		break;
		
		case 4: main.updateEmp();
		break;
		
		case 5: main.deleteEmp();
		break;
		}
	}
	}
}

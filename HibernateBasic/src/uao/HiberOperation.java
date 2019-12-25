package uao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import scs.Student;

public class HiberOperation {
	Configuration cfg;
	SessionFactory sf;
	
	void configure() 
	{
		 cfg= new Configuration();
		 cfg.configure("hibernate.cfg.xml");
         sf= cfg.buildSessionFactory();
	}
    void insert(int rno,String sname,String branch,int fees)
    {
    	 Session s =sf.openSession();
         Transaction tx = s.beginTransaction();
         Student obj = new Student();
         obj.setRno(rno);
         obj.setSname(sname);
         obj.setBranch(branch);
         obj.setFees(fees);
         s.save(obj);
         tx.commit();
         s.close();
    }
    void update(int rno,String sname,String branch,int fees)
    {
    	 Session s =sf.openSession();
         Transaction tx = s.beginTransaction();
         Student obj = new Student();
         obj.setRno(rno);
         obj.setSname(sname);
         obj.setBranch(branch);
         obj.setFees(fees);
         s.update(obj);
         tx.commit();
         s.close();
    }
    void delete(int r)
    {
    	 SessionFactory sf = cfg.buildSessionFactory();
         Session s =sf.openSession();
         Transaction tx = s.beginTransaction();
         Object obj = s.get(Student.class, r);
         s.delete(obj);
         tx.commit();
         s.close();
    }
    void select()
    {
    	Session s = sf.openSession();
		Query q = s.createQuery("from Student s");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Student stu =(Student) it.next();
			System.out.println(stu.getRno()+" "+stu.getSname()+" "+stu.getBranch()+" "+stu.getFees()); 
		}
		s.close();
    	
    }
	public static void main(String[] args) {
		HiberOperation obj = new HiberOperation();
		obj.configure();
		while(true)
		{
			
		Scanner sc = new Scanner(System.in);
		
		int ch;
		int rno,fees;
		String sname,branch;
		System.out.println("press 1 for insertion");
		System.out.println("press 2 for updation");
		System.out.println("press 3 for deletion");
		System.out.println("press 4 for selection");
		System.out.println("press 5 for exit");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.print("enter rno,sname,branch and fees");
			obj.insert(sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
			break;
		case 2:
			System.out.print("enter rno,sname,branch and fees");
			obj.update(sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
			break;
		case 3:
			System.out.print("enter rno,sname,branch and fees");
			obj.delete(sc.nextInt());
			break;
		case 4:
			obj.select();
			break;
		case 5:
			System.exit(0);
			break;
			
		}
		}

	}

}

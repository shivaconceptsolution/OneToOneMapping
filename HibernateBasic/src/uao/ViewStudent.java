package uao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import scs.Student;

public class ViewStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
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

}

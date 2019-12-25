package uao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import scs.Student;

public class StudentOperation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s =sf.openSession();
        Transaction tx = s.beginTransaction();
        Student obj = new Student();
        obj.setRno(1002);
        obj.setSname("jayprakash");
        obj.setBranch("CS");
        obj.setFees(12000);
        s.save(obj);
        tx.commit();
        s.close();
	}

}

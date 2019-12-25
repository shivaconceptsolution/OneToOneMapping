package uao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import scs.Student;

public class DeleteStudentOperation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s =sf.openSession();
        Transaction tx = s.beginTransaction();
        /*Student obj = new Student();
        obj.setRno(1001);
        obj.setSname("manish");
        obj.setBranch("EC");
        obj.setFees(52000);*/
        Object obj = s.get(Student.class, 1002);
        s.delete(obj);
        tx.commit();
        s.close();

	}

}

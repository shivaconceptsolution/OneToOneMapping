package uao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import scs.Customer;
import scs.Student;
import scs.Vendor;

public class CallMappingFile {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s =sf.openSession();
        Transaction tx = s.beginTransaction();
        Vendor v = new Vendor();
        v.setVid(1001);
        v.setVname("SCS");
        Customer c1 = new Customer();
        c1.setCustomerid(1);
        c1.setCustomername("manish");
        Customer c2 = new Customer();
        c2.setCustomerid(2);
        c2.setCustomername("Uday");
        Customer c3 = new Customer();
        c3.setCustomerid(3);
        c3.setCustomername("Birendra");
        Set st = new HashSet();
        st.add(c1);
        st.add(c2);
        st.add(c3);
        v.setChild(st);
        s.save(v);
        tx.commit();
        s.close();

	}

}

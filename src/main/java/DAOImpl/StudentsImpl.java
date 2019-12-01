package DAOImpl;

import DAOInterface.StudntsDAO;
import models.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StudentsImpl implements StudntsDAO {

    public Students findById(int id) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Students globalUrl=session.get(Students.class,id);
        session.close();
        return globalUrl;    }

    public void save(Students globalUrl) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(globalUrl);
        tx1.commit();
        session.close();
    }

    public void update(Students globalUrl) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(globalUrl);
        tx1.commit();
        session.close();

    }

    public void delete(Students globalUrl) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(globalUrl);
        tx1.commit();
        session.close();
    }

    public List<Students> findAll(){
        return (List<Students>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Students").list();
    }
}

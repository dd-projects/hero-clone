package com.heroclone.api.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroclone.api.dao.SampleDAO;
import com.heroclone.api.model.Sample;

@Repository
public class SampleDAOImpl implements SampleDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Sample s) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Sample> list() {
        Session session = this.sessionFactory.openSession();
        List<Sample> sampleList = session.createQuery("from Sample").list();
        session.close();
        return sampleList;
    }

}

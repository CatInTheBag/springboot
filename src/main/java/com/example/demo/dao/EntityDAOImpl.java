package com.example.demo.dao;

import com.example.demo.model.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EntityDAOImpl implements EntityDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Data> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Data> query = currentSession.createQuery("from Data", Data.class);
        List<Data> list = query.getResultList();
        return list;
    }

    @Override
    public Data get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Data dataObj = currentSession.get(Data.class, id);
        return dataObj;
    }

    @Override
    public void save(Data data) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(data);
    }

    /*@Override
    public void delete(Data data) {

    }*/
}

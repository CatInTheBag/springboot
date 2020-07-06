package com.example.demo.service;

import com.example.demo.dao.EntityDAO;
import com.example.demo.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private EntityDAO entityDAO;

    @Transactional
    @Override
    public List<Data> get() {
        return entityDAO.get();
    }

    @Transactional
    @Override
    public Data get(int id) {
        return  entityDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Data data) {
        entityDAO.save(data);
    }

    /*@Transactional
    @Override
    public void delete(Data data) {

    }*/
}

package com.example.demo.dao;

import com.example.demo.model.Data;

import java.util.List;

public interface EntityDAO {
    List<Data> get();

    Data get(int id);

    void save(Data data);

    /*void delete(Data data);*/
}

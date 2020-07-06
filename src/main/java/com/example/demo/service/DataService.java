package com.example.demo.service;

import com.example.demo.model.Data;

import java.util.List;

public interface DataService {
    List<Data> get();

    Data get(int id);

    void save(Data data);

    /*void delete(Data data);*/
}

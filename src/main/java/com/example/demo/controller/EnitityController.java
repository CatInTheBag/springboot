package com.example.demo.controller;

import com.example.demo.model.Data;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnitityController {

    @Autowired
    private DataService dataService;

    @GetMapping("/data")
    public List<Data> get(){
        return dataService.get();
    }

    @GetMapping("/data/{id}")
    public Data get(@PathVariable int id){
        return dataService.get(id);
    }
}

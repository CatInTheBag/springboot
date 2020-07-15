package com.example.demo.controller;

import com.example.demo.helper.HelperClass;
import com.example.demo.model.Data;
import com.example.demo.model.InputData;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnitityController {
    @Autowired
    private HelperClass helperClass;

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

    @PostMapping("/check")
    public void check(@RequestBody InputData request) {
        String currentValue = request.getStr();

        List<String> polidrome = helperClass.checkIfPolindrom(currentValue);

         for( String element : polidrome){
             dataService.save(new Data(element));
         }
    }
}

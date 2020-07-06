package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "entity")
public class Data {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String text;

    @Column
    private Date created;

    public Data(String text) {
        this();
        this.text = text;
    }

    public Data(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    /*@Override
    public String toString() {
        return super.toString();
    }*/
}

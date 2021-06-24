package com.adrian.boada.api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand, model;
    private double price;

    public exam(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public exam() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        exam exam = (exam) o;
        return id == exam.id && Double.compare(exam.price, price) == 0 && brand.equals(exam.brand) && model.equals(exam.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


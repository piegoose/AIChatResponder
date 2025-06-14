package pl.discounter.aimotostore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String category;
    private String subcategory;
    private String description;
    private String brand;
    private double price;
    private int stock;
    private double rating;


}

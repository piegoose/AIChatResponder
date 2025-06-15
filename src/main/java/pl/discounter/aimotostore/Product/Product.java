package pl.discounter.aimotostore.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    //;id;name;category;subcategory;description;brand;price;stock;rating

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String category;

    private String subcategory;

    private String description;

    private String brand;

    private double price;

    private int stock;

    private double rating;




}

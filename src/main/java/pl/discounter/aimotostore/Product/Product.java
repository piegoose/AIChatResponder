package pl.discounter.aimotostore;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    //;id;name;category;subcategory;description;brand;price;stock;rating

    @Id
    private String id;

    private String name;

    private String category;

    private String subcategory;

    private String description;

    private String brand;

    private double price;

    private int stock;

    private double rating;




}

package pl.discounter.aimotostore.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity//(name = "name123")
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ProductEntity {

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

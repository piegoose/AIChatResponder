package pl.discounter.aimotostore.Product;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCsvRepresentation {


    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "category")
    private String category;

    @CsvBindByName(column = "brand")
    private String brand;

    @CsvBindByName(column = "price")
    private double price;
    @CsvBindByName(column = "subcategory")
    private String subcategory;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "stock")
    private int stock;

    @CsvBindByName(column = "rating")
    private double rating;

}

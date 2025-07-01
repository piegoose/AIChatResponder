package pl.discounter.aimotostore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.discounter.aimotostore.product.Product;
import pl.discounter.aimotostore.product.ProductRepository;

@SpringBootApplication
public class AiMotoStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiMotoStoreApplication.class, args);
    }
    @Bean
    CommandLineRunner run(ProductRepository repo) {
        return args -> {
            Product p = new Product();
            p.setName("Test product");
            p.setPrice(199.99);
            // ustaw inne pola jeśli trzeba
            repo.save(p);
        };
    }

}

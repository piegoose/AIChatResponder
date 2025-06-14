package pl.discounter.aimotostore;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/find")
    public List<Product> findAll()
    {
        return repository.findAll();
    }
    

}

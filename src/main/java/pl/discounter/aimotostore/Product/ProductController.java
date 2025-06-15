package pl.discounter.aimotostore.Product;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadProducts(
            @RequestPart("file")MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(service.uploadProducts(file));
    }

    @GetMapping(value = "showall")
    public ResponseEntity<List<Product>> showAll(){
        return ResponseEntity.ok(service.getAllProducts());
    }


}

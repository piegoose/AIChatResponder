package pl.discounter.aimotostore.Product;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Integer uploadProducts(MultipartFile file) throws IOException {
        Set<Product> products = parseCsv(file);
        repository.saveAll(products);
        return products.size();
    }

    private Set<Product> parseCsv(MultipartFile file) throws IOException {
        // Wczytanie i czyszczenie linii CSV
        List<String> cleanedLines;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            cleanedLines = br.lines()
                    .map(line -> line.replaceAll("^;+", "")) // usuwa średniki z początku każdej linii
                    .filter(line -> !line.trim().isEmpty()) // pomija puste linie
                    .toList();
        }

        // Połącz linie z powrotem w jeden tekst
        String cleanedCsvContent = String.join("\n", cleanedLines);
        Reader cleanedReader = new StringReader(cleanedCsvContent);

        // Konfiguracja OpenCSV
        HeaderColumnNameMappingStrategy<ProductCsvRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(ProductCsvRepresentation.class);

        CsvToBean<ProductCsvRepresentation> csvToBean =
                new CsvToBeanBuilder<ProductCsvRepresentation>(cleanedReader)
                        .withMappingStrategy(strategy)
                        .withSeparator(';')
                        .withIgnoreEmptyLine(true)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withThrowExceptions(false)
                        .build();

        // Parsowanie i mapowanie do Product
        return csvToBean.parse()
                .stream()
                .map(csv -> {
                    System.out.println("✅ CSV: name=" + csv.getName() + ", category=" + csv.getCategory());
                    return Product.builder()
                            .name(csv.getName())
                            .category(csv.getCategory())
                            .subcategory(csv.getSubcategory())
                            .description(csv.getDescription())
                            .brand(csv.getBrand())
                            .price(csv.getPrice())
                            .stock(csv.getStock())
                            .rating(csv.getRating())
                            .build();
                })
                .collect(Collectors.toSet());
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

}

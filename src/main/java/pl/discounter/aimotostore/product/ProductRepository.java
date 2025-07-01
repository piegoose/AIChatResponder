package pl.discounter.aimotostore.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Query(value = """
        select product from ProductEntity product
        where product.id = 1
""")
    void updateProductById();

    @Modifying
    @Query(nativeQuery = true, value = """
            delete from products where id = :id
            """)
    void delete(long id);
}


package com.example.PracticeDemo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setUpBeforeTest() throws Exception{
        productService = new ProductService(productRepository);
    }

    @Test
    public void fetchproductreturnproduct() throws Exception {
        given(productRepository.findById(anyLong())).willReturn(java.util.Optional.of(new Product("APPLE304", "APPLE X1","NEW MODEL")));

        Product product = productService.findById((long) 1);
        assertTrue(product.getpd_id() == "APPLE304");
        assertTrue(product.getpd_name() == "APPLE X1");
        assertTrue(product.getpd_desc() == "NEW MODEL");

    }


    @Test
    public void getAllProductReturnAllProduct() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("APPLE304", "APPLE X1","NEW MODEL"));
        given(productRepository.findAll()).willReturn(products);

        List<ProductEntity> test = productService.findAll();
        assertTrue(test.get(0)..getpd_id() == "APPLE304");
        assertTrue(test.get(0).getpd_name() == "APPLE X1");
        assertTrue(test.get(0).getpd_desc() == "NEW MODEL");

    }


}

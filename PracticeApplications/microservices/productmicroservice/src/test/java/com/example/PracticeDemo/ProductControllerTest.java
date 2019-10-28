package com.example.PracticeDemo;

import com.example.productapplication.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;




    @Test
    public void sendproductreturnproduct() throws Exception {
        given(productService.findById(anyLong())).willReturn(new ProductEntity("APPLE304", "APPLE X1","NEW MODEL"));
        mockMvc.perform(MockMvcRequestBuilders.get("/newstore//product/find/1")).andExpect(status().isFound())
                .andExpect(jsonPath("pd_id").value("APPLE304"))
                .andExpect(jsonPath("pd_name").value(" APPLE X1"))
                .andExpect(jsonPath("desc").value(" NEW MODEL"));
    }



    @Test
    public void findallproductsreturnproduct() throws Exception {
        List<ProductEntity> product = new ArrayList<>();
        product.add(new Product("APPLE304",  "APPLE X1","NEW MODEL"));
        product.add(new Product("HP 11308","HP LAPTOP", "FUTURE TECHNOLOGY"));
        given(productService.findAll()).willReturn(output);
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }



    @Test
    public void createProductThenReturnStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newstore/allProducts")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Product("APPLE304",  "APPLE X1","NEW MODEL"))))
                .andExpect(status().isCreated());


    }
















}
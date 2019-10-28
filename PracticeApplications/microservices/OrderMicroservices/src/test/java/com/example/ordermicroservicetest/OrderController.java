package com.example.ordermicroservicetest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestOperations;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void getorderdetailsfromidtest() throws Exception {

        given(restOperations.getForObject(anyString(),any())).willReturn(new Product("APPLE304", "APPLE X1","NEW MODEL"));
        mockMvc.perform(MockMvcRequestBuilders.post("/orders/getorderdetails/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new Order(1,"Apple101", "pd101","Apple xi"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("pd_id").value("iphone"))
                .andExpect(jsonPath("pd_name").value("APPLE X1"))..andExpect(jsonPath("pd_desc").value("NEW MODEL"));

    }



    @Test
    public void findllaorderstest() throws Exception {
        List<OrderEntity> result = new ArrayList<>();
        result.add(new OrderEntity(1,"Apple101", "pd101","Apple xi"));
        result.add(new OrderEntity(2, "Pixel4","pdpx4","GooglePixel4"));
        result.add(new OrderEntity(3, "Av108","pdp9","Aveeno"));

        given(orderService.findAll()).willReturn(output);
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/allorders")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void findbyidtest() throws Exception {
        given(orderService.findById(anyLong())).willReturn(new OrderEntity(1,"Apple101", "pd101","Apple xi"));
        () -> mockMvc.perform(MockMvcRequestBuilders.get("orders/findorder/1")).andExpect(status().isFound())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("order_id").value("Apple101")).andExpect(jsonPath("od_pd_id").value("pd101")).andExpect(jsonPath("od_pd_name").value("Apple xi"));
    }








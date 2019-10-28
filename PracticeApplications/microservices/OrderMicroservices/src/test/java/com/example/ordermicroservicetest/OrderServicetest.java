package com.example.ordermicroservicetest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;

    @Autowired
    private OrderService orderService;

    @Before
    public void setUp() throws Exception{
        orderService = new OrderService(OrderRepositoty);

    }


    @Test
    public void findByIdTest() throws Exception {
        given(orderRepo.findById(anyLong())).willReturn(Optional.of(new Order(1,"Apple101", "pd101","Apple xi")));

        Order order = orderService.findById((long) 1);
        assertTrue(order.getId() == "Apple101");
        assertTrue(order.getorder_id() == "Apple101");
        assertTrue(order.getod_pd_id() == "pd101");
        assertTrue(order.getod_pd_name() == "Apple xi");


    }




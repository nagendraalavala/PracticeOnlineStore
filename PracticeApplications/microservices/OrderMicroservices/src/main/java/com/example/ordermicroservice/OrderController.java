package com.example.ordermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    RestTemplate restTemplate;


    private OrderService orderService;
    private RestOperation restOperation;

    @Autowired
    public OrderController(OrderService orderservice,RestOperation restoperation)
    {
        this.orderService=orderservice;
        this.restOperation=restoperation;
    }


    @PostMapping("/addorder")
    public OrderEntity createorder(OrderEntity orderEntity)
    {
        return orderService.createorder(orderEntity);
    }

    @GetMapping("/allorders")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> getallorders()
    {
        return orderService.getallorders();
    }

    @GetMapping("/findorder/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<OrderEntity> getorderbyid(@PathVariable long id)
    {
        return orderService.getorderbyId(id);
    }

    @PostMapping("/getorderdetails/{id}")
    public ResponseEntity<Productntity> create(@RequestBody OrderEntity orderEntity){
        String url = "http://localhost:8080/product/";
        ProductEntity productEntity = restOperations.getForObject(url+order.getProductId(), Product.class);
        orderService.save(orderEntity);
        return new ResponseEntity<>(productEntity, HttpStatus.CREATED);
    }
}



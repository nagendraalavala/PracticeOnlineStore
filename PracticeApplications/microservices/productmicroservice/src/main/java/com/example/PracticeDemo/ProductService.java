package com.example.PracticeDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{

    private ProductRepository productRepository;
    private ProductEntity productEntity;

    @Autowired
    public ProductService(ProductRepository productRepository,ProductEntity productEntity)
    {
        this.productRepository=productRepository;
        this.productEntity=productEntity;
    }




    //AddProduct
    public ProductEntity addProduct(ProductEntity productEntity)
    {
        return productRepository.save(productEntity);
    }

    //GetAllProducts
    public List<ProductEntity> getAllProducts()
    {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity findById(Long id)
    {
        ProductEntity output = null;
        Optional<ProductEntity> productEntity=productRepository.findById(id);
        if(productEntity.isPresent())
        {
            output= productEntity.get();
        }


        return output;
    }


    public String getorderdetails(long id)
    {
        String output = null;
        if(productEntity.getPd_id().equals(id))
        {
            output=productEntity.getPd_name()+productEntity.getPd_desc();
        }return output;
    }





}
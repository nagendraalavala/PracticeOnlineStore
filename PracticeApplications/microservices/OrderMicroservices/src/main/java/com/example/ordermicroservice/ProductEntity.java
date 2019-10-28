package com.example.ordermicroservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pd_Id;

    private String pd_id;
    private String pd_name;
    private String pd_desc;

    public ProductEntity(int i, String pd_id, String pd_name, String pd_desc) {
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public String getPd_desc() {
        return pd_desc;
    }

    public void setPd_desc(String pd_desc) {
        this.pd_desc = pd_desc;
    }

    @Override
    public String toString()
    {
        return "ProductEntity{" +
                "Id=" + pd_Id +
                ", pd_id='" + pd_id + '\'' +
                ", pd_name='" + pd_name + '\'' +
                ", pd_desc='" + pd_desc + '\'' +
                '}';
    }



}

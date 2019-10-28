package com.example.ordermicroservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;



    private String order_id;
    private String od_pd_id;
    private String od_pd_name;

    public OrderEntity(Long id,  String order_id, String od_pd_id, String od_pd_name) {
        Id = id;

        this.order_id = order_id;
        this.od_pd_id = od_pd_id;
        this.od_pd_name = od_pd_name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }




    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOd_pd_id() {
        return od_pd_id;
    }

    public void setOd_pd_id(String od_pd_id) {
        this.od_pd_id = od_pd_id;
    }

    public String getOd_pd_name() {
        return od_pd_name;
    }

    public void setOd_pd_name(String od_pd_name) {
        this.od_pd_name = od_pd_name;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "Id=" + Id +

                ", order_id='" + order_id + '\'' +
                ", od_pd_id='" + od_pd_id + '\'' +
                ", od_pd_name='" + od_pd_name + '\'' +
                '}';
    }
}

package io.renren.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private OrderEntity orderEntity;
    private List<OrderDescEntity> orderDescEntity;

    public Order() {
    }

    public Order(OrderEntity orderEntity, List<OrderDescEntity> orderDescEntity) {
        this.orderEntity = orderEntity;
        this.orderDescEntity = orderDescEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public List<OrderDescEntity> getOrderDescEntity() {
        return orderDescEntity;
    }

    public void setOrderDescEntity(List<OrderDescEntity> orderDescEntity) {
        this.orderDescEntity = orderDescEntity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderEntity=" + orderEntity +
                ", orderDescEntity=" + orderDescEntity +
                '}';
    }
}

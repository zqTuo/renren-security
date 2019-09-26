package io.renren.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Order implements Serializable {
    private Long num;

    private boolean isEnableSeller;

    private OrderEntity orderEntity;

    private List<OrderDescEntity> orderDescEntity;


}

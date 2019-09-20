package io.renren.modules.sys.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
@Data
public class Order implements Serializable {

    private OrderEntity orderEntity;

    private List<OrderDescEntity> orderDescEntity;
    @NotBlank(message="奖品不能为空")
    private BonusEntity bonusEntity;

}

package io.renren.modules.sys.dto;

import io.renren.common.utils.poi.model.ExcelBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends ExcelBean {
    /**
     * 店铺名称
     */
    private String nickName;
    /**
     * EMAIL
     */
    private String email;
    /**
     * 公司手机
     */
    private String mobile;
    /**
     * 公L司电话
     */
    private String telephone;
    /**
     * 状态
     */
    private String status;
    /**
     * 区域
     */
    private String region;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 联系人姓名
     */
    private String linkmanName;
    /**
     * 联系人QQ
     */
    private String linkmanQq;
    /**
     * 联系人电话
     */
    private String linkmanMobile;
    /**
     * 联系人EMAIL
     */
    private String linkmanEmail;
    /**
     * 职位
     */
    private String linkmanJod;
    /**
     * 是否连锁经营
     */
    private String storeSize;
    /**
     * 是否支持地推
     */
    private String addressGround;
    /**
     * 店面大小
     */
    private String linkmanOperation;
    /**
     * 营业执照号
     */
    private String licenseNumber;
    /**
     * 税务登记证号
     */
    private String taxNumber;
    /**
     * 组织机构代码
     */
    private String orgNumber;
    /**
     * 公司地址
     */
    private Long address;
    /**
     * 奶茶店周边
     */
    private String addressShop;
    /**
     * 简介
     */
    private String brief;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 法定代表人
     */
    private String legalPerson;
    /**
     * 距离周边距离
     */
    private String addressDistance;
    /**
     * 分类
     */
    private String shopCategory;
    /**
     * 门店合作等级
     */
    private String shopLv;
}

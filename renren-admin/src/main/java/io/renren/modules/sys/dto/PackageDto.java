package io.renren.modules.sys.dto;

import io.renren.common.utils.poi.model.ExcelBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * 功能描述: <br>
 * 包裹
 * @since: 1.0.0
 * @Author:Created By Clarence
 * @Date: 2019/7/8 11:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDto extends ExcelBean {
    private long id;
    // 包裹状态 -1：待入库(预期包裹)  0：待支付（已入库，待支付）
    // 1：支付成功 2：待寄出 3：已寄出 4：已确认（用户已签收）
    private int state;
    private String recordNo; // 包裹编号
    private String oldExpressNo; // 物流单号（仓库收到包裹时的物流单号）
    private String expressNo; // 新物流单号（派送至国内的物流单号）
    private String createTime; // 创建时间
    private String senderName; // 寄件人姓名（实名）
    private String zipCode; // 邮编 如深圳：518000
    private String receiveCountry; // 收件人 国家
    private String receiverProv; //收件地址_省份
    private String receiverCity; // 收件地址_城市
    private String receiverDist;//收件地址_区域
    private String receiverAddr; // 收件地址
    private String receiverPhone; // 收件人联系方式
    private String receiver;//收件人
    private int declareType; // 海关申报类型（包裹描述）0：礼物 1：文件 2：样品 3：其他
    private String remark; // 备注
    private String barCode; // 条形码图片路径
    private String weight; // 包裹净重
    private BigDecimal price; // 合计费用
    private Integer selfPick; // 是否自提 0：不自提  1：自提
    private String shipWayCode;// 运送方式编码 EEXPRESS     香港进口E 特快

   /* public PackageDto() {
        super(operationCode, resultInfo, successFlag);
    }*/
}

package org.zhouzhou.intv.entity;

import lombok.Data;

/**
 *  顾客的综合信息，包含顾客名字+顾客积分+顾客下单信息，来自不同系统
 *  对外暴露一个CustomerMixInfo
 */
@Data
public class CustomerMixInfo
{
    private Long cid;

    private String cname;
    private Long score;
    private String orderInfo;
}

package org.zhouzhou.intv.aoppreview;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService{
    @Override
    public void pay()
    {
        System.out.println("PayServiceImpl微信支付业务逻辑："+ IdUtil.simpleUUID());

        int age=10/0;
    }
}

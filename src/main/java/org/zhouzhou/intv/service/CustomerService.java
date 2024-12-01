package org.zhouzhou.intv.service;

import org.zhouzhou.intv.entity.CustomerMixInfo;

public interface CustomerService
{
    public CustomerMixInfo findCustomer();

    public CustomerMixInfo findCustomerByCompletableFuture ();
}

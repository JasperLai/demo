package com.example.demo.business.customer.client;

import java.util.List;
import com.example.demo.business.customer.client.dto.CustomerPositionDTO;

public interface CustomerPositionService {
    
    /**
     * 查询指定债券代码列表的客户持仓信息
     */
    List<CustomerPositionDTO> queryCustomerPositions(List<String> bondCodes);
} 
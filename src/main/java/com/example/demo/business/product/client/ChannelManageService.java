package com.example.demo.business.product.client;

import java.util.List;

import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.request.TraderDTO;
import com.example.demo.business.product.app.dto.request.TraderVO;
import com.example.demo.business.product.app.dto.request.TransferVO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.common.exception.data.ListData;

public interface ChannelManageService {

    // Public methods for bond quota services
    public void bondQuotaBatchTransfer(String bondCode, String outOrg, List<TransferVO> inQuota, TransactionVO vo); // 债券额度批量调拨

    public void bondQuotaTransfer(String outOrg, String inOrg, long amount, String bondCode); // 债券额度调拨

    public QuotaDTO queryQuota(String bondCode, String productID); // 债券额度查询

    public void setQuotaLimit(String bondCode, long highLimit, long lowLimit); // 库存上下限设置

    // Public methods for trader services
    public void addTrader(TraderVO vo); // 交易商录入

    public void deleteTrader(String agentCode); // 交易商删除

    public void storeTrader(TraderVO vo); // 交易商更新

    public TraderDTO queryTrader(String agentCode); // 交易商查询

    public ListData<TraderDTO> queryTraderList(TraderVO vo); // 交易商列表查询
}

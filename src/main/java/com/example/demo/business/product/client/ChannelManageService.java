package com.example.demo.business.product.client;

import java.util.List;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.app.dto.request.TraderDTO;
import com.example.demo.business.product.app.dto.request.QuotaTransferDTO;
import com.example.demo.business.product.app.dto.response.InventoryDTO;
import com.example.demo.common.exception.data.ListData;
import com.example.demo.common.response.Response;

public interface ChannelManageService {

    // Public methods for bond quota services
    public void bondQuotaBatchTransfer(String bondCode, String outOrg, List<QuotaTransferDTO> inQuota, TransactionDTO vo); // 债券额度批量调拨

    public void bondQuotaTransfer(String outOrg, String inOrg, long amount, String bondCode); // 债券额度调拨

    public Response<InventoryDTO> queryQuota(String bondCode, String productID); // 债券额度查询

    public void updateInventory(String bondCode, String orgNum, long amount, String type); // 更新库存

    // Public methods for trader services
    public void addTrader(TraderDTO vo); // 交易商录入

    public void deleteTrader(String agentCode); // 交易商删除

    public void storeTrader(TraderDTO vo); // 交易商更新

    public TraderDTO queryTrader(String agentCode); // 交易商查询

    public ListData<TraderDTO> queryTraderList(TraderDTO vo); // 交易商列表查询
}

package com.example.demo.business.product.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.product.app.dto.request.TraderDTO;
import com.example.demo.business.product.app.dto.request.QuotaTransferDTO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.business.product.client.ChannelManageService;
import com.example.demo.business.product.domain.entity.Inventory;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.business.product.domain.service.InventoryService;
import com.example.demo.common.exception.data.ListData;

import java.util.List;

@Service
public class ChannelManageServiceImpl implements ChannelManageService {

    // Injecting private services using IoC (Spring @Autowired)
    @Autowired
    private BondProductService bondProductService;

    @Autowired
    private BondProductRepository bondProductRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TMSInterface transactionManageService;

    // Public methods for bond quota services
    @Override
    public void bondQuotaBatchTransfer(String bondCode, String outOrg, List<QuotaTransferDTO> transferList,
            TransactionDTO transactionVO) {

        String transID = transactionManageService.createTransaction(transactionVO, TradeType.BOND_QUOTA_TRANSFER);
        //Retrieve inventory for the bond from outOrg
        Inventory outInventory = inventoryService.queryInventory(bondCode, outOrg);

        //Validate if outOrg has sufficient quota for all transfers
        long totalTransferAmount = transferList.stream().mapToLong(QuotaTransferDTO::getAmount).sum();
        // if (outInventory.getAvailableQuota() < totalTransferAmount) {
        //     throw new IllegalArgumentException("Insufficient quota in " + outOrg);
        // }

        //Process each transfer
        for (QuotaTransferDTO transfer : transferList) {
            String inOrg = transfer.getOrgId(); // Target organization
            long amount = transfer.getAmount(); // Transfer amount
            // Reduce quota from outOrg's inventory
            inventoryService.transferInventory(bondCode, amount, outOrg, inOrg);
        }

        //Record the transaction using the provided transactionVO
        transactionManageService.updateTransaction(transID, TransStatus.SUCCESS);
    }

    @Override
    public void bondQuotaTransfer(String outOrg, String inOrg, long amount, String bondCode) {
        // Business logic for bond quota transfer
    }

    @Override
    public QuotaDTO queryQuota(String bondCode, String productID) {
        // Business logic for querying quota
        // Returning a placeholder response for now
        return new QuotaDTO();
    }

    @Override
    public void setQuotaLimit(String bondCode, long highLimit, long lowLimit) {
        // Business logic for setting quota limit
    }

    // Public methods for trader services
    @Override
    public void addTrader(TraderDTO vo) {
        // Business logic for adding a trader
    }

    @Override
    public void deleteTrader(String agentCode) {
        // Business logic for deleting a trader
    }

    @Override
    public void storeTrader(TraderDTO vo) {
        // Business logic for storing/updating a trader
    }

    @Override
    public TraderDTO queryTrader(String agentCode) {
        // Business logic for querying a trader
        // Returning a placeholder response for now
        return new TraderDTO();
    }

    @Override
    public ListData<TraderDTO> queryTraderList(TraderDTO vo) {
        // Business logic for querying trader list
        // Returning a placeholder response for now
        return new ListData<>();
    }
}

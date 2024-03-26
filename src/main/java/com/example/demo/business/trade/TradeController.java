package com.example.demo.business.trade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.trade.client.TradeManageService;
import com.example.demo.business.trade.domain.domainObject.BondOrder;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final TradeManageService tradeService;

    // Constructor injection is preferred for Spring beans
    public TradeController(TradeManageService tradeService) {
        this.tradeService = tradeService;
    }

    // @PostMapping
    // public ResponseEntity<String> processTrade(@RequestBody BondOrder order) {
    //     tradeService.processTrade(order);
    //     return ResponseEntity.ok("Trade processed successfully");
    // }
}


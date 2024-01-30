package com.example.demo.business.product.app;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.business.product.app.request.QueryKeAcPriceRequest;
import com.example.demo.business.product.app.request.QuotationPreviewRequest;
import com.example.demo.business.product.app.response.QueryKeAcPriceResponse;
import com.example.demo.business.product.domain.domainObject.BondQuotation;

public class QuotationManageController {

     /**
     * 报价试算
     * 
     * @param list 
     * @return
     */
    @PostMapping("/quotation/preview")
    public List<BondQuotation> keepAccountsPriceCountBatch(@RequestBody List<QuotationPreviewRequest> list) {

        return null;
    }


     /**
     * 报价试算
     * 
     * @param list 
     * @return
     */
    @PostMapping("/quotation/set")
    public List<BondQuotation> keepAccountsPriceSetBatch(@RequestBody List<QuotationPreviewRequest> list) {

        return null;
    }


    /**
     * 查询
     * @param list
     * @return
     */
    @PostMapping("/quotation/set")
    public List<QueryKeAcPriceResponse> queryKeAcPrice(@RequestBody QueryKeAcPriceRequest request) {

        return null;
    }
}

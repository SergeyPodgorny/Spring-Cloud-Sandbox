package com.springcloud.demo.bill.controller;


import com.springcloud.demo.bill.dto.BillDTO;
import com.springcloud.demo.bill.entity.Bill;
import com.springcloud.demo.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class BillController {


    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }


    /**
     * Crud method for bill entity
     */
    @PostMapping("/bills")
    public void createBill(@RequestBody BillDTO billDTO){

        Bill creatingBill = new Bill(billDTO.getAccountId(), billDTO.getAmount(), billDTO.getIsDefault(),billDTO.getOverDraftEnabled(),
                OffsetDateTime.now());

        billService.createBill(creatingBill);

    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long billId){
        return billService.getBillById(billId);

    }

    @PutMapping("/{id}")
    public void updateBill(Long billId, @RequestBody BillDTO billDTO){
        billService.updateBill(billId, billDTO);
    }

    public void deleteBillById(Long billId){
        billService.deleteBillById(billId);
    }

}

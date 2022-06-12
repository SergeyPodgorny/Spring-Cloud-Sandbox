package com.springcloud.demo.bill.service;

import com.springcloud.demo.bill.dto.BillDTO;
import com.springcloud.demo.bill.entity.Bill;
import com.springcloud.demo.bill.exceptions.BillNotFoundException;
import com.springcloud.demo.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class BillService {


    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void createBill(Bill bill) {
        billRepository.save(bill);
    }

    public Bill getBillById(Long billId){

        return billRepository.findById(billId).orElseThrow(() -> new BillNotFoundException("Required bill with id: " + billId + "not found"));

    }

    public void updateBill(Long billId, BillDTO billDTO){
        Bill billToBeUpdated = new Bill();
        billToBeUpdated.setBillId(billId);
        billToBeUpdated.setAmount(billDTO.getAmount());
        billToBeUpdated.setAccountId(billDTO.getAccountId());
        billToBeUpdated.setIsDefault(billDTO.getIsDefault());
        billToBeUpdated.setIsOverDraftEnabled(billDTO.getOverDraftEnabled());
        billRepository.save(billToBeUpdated);


    }

    public void deleteBillById(Long billId) {
        Bill billToBeDeleted = getBillById(billId);
        billRepository.delete(billToBeDeleted);
    }







}

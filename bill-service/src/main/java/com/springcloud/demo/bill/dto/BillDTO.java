package com.springcloud.demo.bill.dto;


import com.springcloud.demo.bill.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@NoArgsConstructor
@Setter
@Getter
public class BillDTO {

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime billCreationDateTime;

    private Boolean overDraftEnabled;

    public BillDTO(Bill bill) {
        this.amount = bill.getAmount();
        this.isDefault = bill.getIsOverDraftEnabled();
        this.accountId = bill.getAccountId();
        this.overDraftEnabled = bill.getIsOverDraftEnabled();
    }
}

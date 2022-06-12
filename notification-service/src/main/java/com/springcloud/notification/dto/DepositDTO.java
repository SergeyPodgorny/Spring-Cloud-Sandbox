package com.springcloud.notification.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;



@Getter
@Setter
public class DepositDTO {

    private BigDecimal amount;

    private String email;

}

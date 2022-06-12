package com.springcloud.demo.bill.exceptions;

import java.time.OffsetDateTime;

public class BillNotFoundException extends RuntimeException {



    public BillNotFoundException(String message) {
        super(message);

    }
}

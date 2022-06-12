package com.springcloud.demo.bill.repository;

import com.springcloud.demo.bill.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<Bill, Long> {
}

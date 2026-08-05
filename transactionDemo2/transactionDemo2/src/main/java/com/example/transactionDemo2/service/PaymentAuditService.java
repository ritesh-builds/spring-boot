package com.example.transactionDemo2.service;

import com.example.transactionDemo2.entity.Order;
import com.example.transactionDemo2.entity.PaymentAudit;
import com.example.transactionDemo2.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private final PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void audit(Order order) {
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount(), order.getId(), true);
        paymentAuditRepository.save(paymentAudit);
    }
}

package impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.paymentservice.model.Payment;
import com.study.paymentservice.resource.PaymentResource;
import com.study.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {

        paymentService.sendPayment(payment);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}

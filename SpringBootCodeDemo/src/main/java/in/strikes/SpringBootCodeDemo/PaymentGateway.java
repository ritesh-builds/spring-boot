package in.strikes.SpringBootCodeDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;

    }

    public String getType(){
        return paymentProperties.getType();
    }

    public int getRetryCount(){
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled(){
        return paymentProperties.isEnabled();
    }

    public int getTimeout(){
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println("PaymentGateway Type : " + getType());
        System.out.println("PaymentGateway Retry Count : " + getRetryCount());
        System.out.println("PaymentGateway enabled : " + isEnabled());
        System.out.println("PaymentGateway timeout : " + getTimeout()+"ms");

    }
}


//    @Value("${paymentGateway.type}")
//    private String type;
//
//    @Value("${paymentGateway.retryCount}")
//    private int retryCount;
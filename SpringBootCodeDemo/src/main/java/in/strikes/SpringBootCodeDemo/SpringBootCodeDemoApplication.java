package in.strikes.SpringBootCodeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCodeDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCodeDemoApplication.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

//		paymentGateway.setType("Paytm");
//		paymentGateway.setRetryCount(5);

//		paymentGateway.print();
	}
}

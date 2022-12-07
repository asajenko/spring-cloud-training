package pl.training.payments.adapters.output.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.net.URI;

@Component
@Log
@RequiredArgsConstructor
public class StreamPaymentAdapter {

    private static final String BROKER_SERVICE_NAME ="BROKER-SERVICE";
    private static final String PAYMENTS_ENDPOINT ="/payments";

    private final DiscoveryClient discoveryClient;

    @PostConstruct
    public void onProcessed() {
        var paymentEvent = new PaymentEvent();
        paymentEvent.setValue("200 PLN");

        /*webClient()
                .post()
                .uri(getBrokerUri())
                .bodyValue(paymentEvent)
                .retrieve()
                .bodyToMono(PaymentEvent.class)
                .subscribe(event -> log.info("Payment processed by broker: " + event), throwable -> log.info(throwable.toString()));*/

        /*webClient()
                .get()
                .uri(getBrokerUri())
                .retrieve()
                .bodyToFlux(PaymentEvent.class)
                .subscribe(event -> log.info("Payment processed by broker: " + event), throwable -> log.info(throwable.toString()));*/

    }

    private WebClient webClient() {
        return WebClient.builder().build();
    }

    private URI getBrokerUri() {
        var instances = discoveryClient.getInstances(BROKER_SERVICE_NAME);
        var instance = instances.stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        return instance.getUri().resolve(PAYMENTS_ENDPOINT);
    }

}

package pl.training.shop.commons;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Endpoint(id = "shop-health")
public class CustomHealthEndpoint {

    @ReadOperation
    public String get() {
        return "Status ok (" + Instant.now() + ")";
    }

}

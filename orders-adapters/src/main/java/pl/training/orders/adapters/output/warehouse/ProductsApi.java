package pl.training.orders.adapters.output.warehouse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "WAREHOUSE-SERVICE")
public interface ProductsApi {

    @GetMapping("products/{id}")
    ProductDto getById(@PathVariable long id);

}

package pl.training.warehouse.adapters.input.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.warehouse.ports.input.UpdateProductsPricesUseCase;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor
public class UpdateProductUseCaseAdapter {

    private final UpdateProductsPricesUseCase updateProductsPricesUseCase;

    @PostMapping
    public ResponseEntity<Void> update() {
        updateProductsPricesUseCase.update();
        return ResponseEntity.accepted().build();
    }

}

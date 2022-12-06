package pl.training.warehouse.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.training.warehouse.ports.GetProductUseCase;

@RestController
@RequiredArgsConstructor
public class GetProductUseCaseAdapter {

    private final GetProductUseCase getProductUseCase;
    private final RestProductMapper mapper;

    @GetMapping("products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        var product = getProductUseCase.getById(id);
        return ResponseEntity.ok(mapper.toDto(product));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<Void> onIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.notFound().build();
    }

}

package pl.training.warehouse.adapters.output.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "Product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class ProductEntity {

    @Id
    private Long id;
    private String name;
    @Column(name = "amount")
    private BigDecimal value;

}

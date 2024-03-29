package pl.training.payments.ports.model;

import lombok.Value;

@Value
public class Page {

    int number;
    int size;

    public int getOffset() {
        return number * size;
    }

}

package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class OutofStock extends AbstractEvent {

    private Long id;

    public OutofStock(Stacking aggregate) {
        super(aggregate);
    }

    public OutofStock() {
        super();
    }
}

package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;

    public StockIncreased(Stacking aggregate) {
        super(aggregate);
    }

    public StockIncreased() {
        super();
    }
}

package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long qty;
    private Long productId;
    private String status;

    public DeliveryCancelled(Delivering aggregate) {
        super(aggregate);
    }

    public DeliveryCancelled() {
        super();
    }
}

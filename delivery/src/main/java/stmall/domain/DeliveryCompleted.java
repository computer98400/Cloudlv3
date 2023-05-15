package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long qty;
    private Long productId;
    private String status;
    private String courier;

    public DeliveryCompleted(Delivering aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}

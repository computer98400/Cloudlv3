package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long qty;
    private Long productId;
    private String status;
    private String courier;
}

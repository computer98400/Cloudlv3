package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class DeliveryCompleteCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private Long orderId;
    private String status;
    private String courier;
    private Long qty;
    private Long productId;
    private String courierName;
}

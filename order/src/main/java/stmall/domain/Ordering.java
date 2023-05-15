package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.OrderApplication;
import stmall.domain.OrderCancelled;
import stmall.domain.Ordered;

@Entity
@Table(name = "Ordering_table")
@Data
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long productId;

    private String productName;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderingRepository repository() {
        OrderingRepository orderingRepository = OrderApplication.applicationContext.getBean(
            OrderingRepository.class
        );
        return orderingRepository;
    }
}

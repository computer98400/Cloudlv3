package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.DeliveryApplication;
import stmall.domain.DeliveryCancelled;
import stmall.domain.DeliveryStarted;

@Entity
@Table(name = "Delivering_table")
@Data
public class Delivering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long orderId;

    private String productName;

    private Long qty;

    private Long productId;

    private String status;

    private String courier;

    // @PostPersist
    // public void onPostPersist() {
    //     // DeliveryStarted deliveryStarted = new DeliveryStarted(this);
    //     // deliveryStarted.publishAfterCommit();
    // }

    @PostUpdate
    public void onPostUpdate() {
        // DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        // deliveryCancelled.publishAfterCommit();
    }

    public static DeliveringRepository repository() {
        DeliveringRepository deliveringRepository = DeliveryApplication.applicationContext.getBean(
            DeliveringRepository.class
        );
        return deliveringRepository;
    }

    public void deliveryComplete(
        DeliveryCompleteCommand deliveryCompleteCommand
    ) {
        this.setCourier(deliveryCompleteCommand.getCourier());
        this.setStatus("delivery Completed");
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public void returnDelivery(ReturnDeliveryCommand returnDeliveryCommand) {
        this.setCourier(returnDeliveryCommand.getCourier());
        this.setStatus("delivery Returned");
        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    public static void deliveryStart(Ordered ordered) {
        // Example 1:  new item 
        Delivering delivering = new Delivering();
        delivering.setOrderId(ordered.getId());
        delivering.setProductId(ordered.getProductId());
        delivering.setProductName(ordered.getProductName());
        delivering.setQty(Long.parseLong(ordered.getQty().toString()));
        delivering.setStatus("Delivery Started");
        repository().save(delivering);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivering);
        deliveryStarted.publishAfterCommit();

        //Example 2:  finding and process
        
        // repository().findById(ordered.getId()).ifPresent(delivering->{            
        //     delivering.setStatus("returned"); // do something
        //     repository().save(delivering);

        //     DeliveryStarted deliveryStarted = new DeliveryStarted(delivering);
        //     deliveryStarted.publishAfterCommit();

        //  });

    }

    public static void deliveryCancel(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        Delivering delivering = new Delivering();
        repository().save(delivering);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivering);
        deliveryCancelled.publishAfterCommit();
        */

        // Example 2:  finding and process
        
        repository().findByOrderId(orderCancelled.getId()).ifPresent(delivering->{
            
            delivering.setStatus("delivery Cancelld"); // do something
            repository().save(delivering);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivering);
            deliveryCancelled.publishAfterCommit();

         });

    }
}

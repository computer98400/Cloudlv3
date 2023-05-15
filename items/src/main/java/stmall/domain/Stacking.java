package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.ItemsApplication;
import stmall.domain.OutofStock;
import stmall.domain.StockIncreased;

@Entity
@Table(name = "Stacking_table")
@Data
public class Stacking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        OutofStock outofStock = new OutofStock(this);
        outofStock.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static StackingRepository repository() {
        StackingRepository stackingRepository = ItemsApplication.applicationContext.getBean(
            StackingRepository.class
        );
        return stackingRepository;
    }

    public static void stockDecrease(DeliveryCompleted deliveryCompleted) {
        /** Example 1:  new item 
        Stacking stacking = new Stacking();
        repository().save(stacking);

        OutofStock outofStock = new OutofStock(stacking);
        outofStock.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(stacking->{
            
            stacking // do something
            repository().save(stacking);

            OutofStock outofStock = new OutofStock(stacking);
            outofStock.publishAfterCommit();

         });
        */

    }

    public static void stockIncrease(DeliveryReturned deliveryReturned) {
        /** Example 1:  new item 
        Stacking stacking = new Stacking();
        repository().save(stacking);

        StockIncreased stockIncreased = new StockIncreased(stacking);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(stacking->{
            
            stacking // do something
            repository().save(stacking);

            StockIncreased stockIncreased = new StockIncreased(stacking);
            stockIncreased.publishAfterCommit();

         });
        */

    }
}

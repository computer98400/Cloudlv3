package stmall.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stmall.domain.*;

@RestController
// @RequestMapping(value="/deliverings")
@Transactional
public class DeliveringController {

    @Autowired
    DeliveringRepository deliveringRepository;

    @RequestMapping(
        value = "deliverings/{id}/deliverycomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Delivering deliveryComplete(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliveryCompleteCommand deliveryCompleteCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /delivering/deliveryComplete  called #####");
        Optional<Delivering> optionalDelivering = deliveringRepository.findById(
            id
        );

        optionalDelivering.orElseThrow(() -> new Exception("No Entity Found"));
        Delivering delivering = optionalDelivering.get();
        delivering.deliveryComplete(deliveryCompleteCommand);

        deliveringRepository.save(delivering);
        return delivering;
    }

    @RequestMapping(
        value = "deliverings/{id}/returndelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Delivering returnDelivery(
        @PathVariable(value = "id") Long id,
        @RequestBody ReturnDeliveryCommand returnDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /delivering/returnDelivery  called #####");
        Optional<Delivering> optionalDelivering = deliveringRepository.findById(
            id
        );

        optionalDelivering.orElseThrow(() -> new Exception("No Entity Found"));
        Delivering delivering = optionalDelivering.get();
        delivering.returnDelivery(returnDeliveryCommand);

        deliveringRepository.save(delivering);
        return delivering;
    }
}

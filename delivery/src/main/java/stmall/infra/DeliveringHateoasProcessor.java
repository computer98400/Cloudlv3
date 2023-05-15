package stmall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmall.domain.*;

@Component
public class DeliveringHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Delivering>> {

    @Override
    public EntityModel<Delivering> process(EntityModel<Delivering> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/deliverycomplete"
                )
                .withRel("deliverycomplete")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/returndelivery")
                .withRel("returndelivery")
        );

        return model;
    }
}

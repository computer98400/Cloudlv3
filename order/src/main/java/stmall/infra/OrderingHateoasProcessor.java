package stmall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmall.domain.*;

@Component
public class OrderingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ordering>> {

    @Override
    public EntityModel<Ordering> process(EntityModel<Ordering> model) {
        return model;
    }
}

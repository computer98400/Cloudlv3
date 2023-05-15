package stmall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmall.domain.*;

@Component
public class StackingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Stacking>> {

    @Override
    public EntityModel<Stacking> process(EntityModel<Stacking> model) {
        return model;
    }
}

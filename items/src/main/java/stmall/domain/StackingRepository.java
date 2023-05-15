package stmall.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmall.domain.*;

@RepositoryRestResource(collectionResourceRel = "stackings", path = "stackings")
public interface StackingRepository
    extends PagingAndSortingRepository<Stacking, Long> {}

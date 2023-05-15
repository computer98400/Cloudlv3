package stmall.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmall.domain.*;

@RepositoryRestResource(collectionResourceRel = "orderings", path = "orderings")
public interface OrderingRepository
    extends PagingAndSortingRepository<Ordering, Long> {}

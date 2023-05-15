package stmall.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmall.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "deliverings",
    path = "deliverings"
)
public interface DeliveringRepository
    extends PagingAndSortingRepository<Delivering, Long> {}

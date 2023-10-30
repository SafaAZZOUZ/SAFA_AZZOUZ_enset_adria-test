package ma.enset.transferservice.repo;

import ma.enset.transferservice.entities.Transfer;
import ma.enset.transferservice.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    @RestResource(path = "/bywalletId")
    List<Wallet> findByCustomerId(@Param("walletId") Long customerId);
}

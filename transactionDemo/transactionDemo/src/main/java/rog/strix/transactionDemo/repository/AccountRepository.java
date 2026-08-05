package rog.strix.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rog.strix.transactionDemo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}

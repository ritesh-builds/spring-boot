package rog.strix.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rog.strix.transactionDemo.entity.TransferRecord;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}

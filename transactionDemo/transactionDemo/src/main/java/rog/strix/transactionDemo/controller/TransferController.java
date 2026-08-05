package rog.strix.transactionDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rog.strix.transactionDemo.entity.TransferRecord;
import rog.strix.transactionDemo.service.TransferService;

@RestController
@RequestMapping("api/transfer")
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(@RequestBody TransferRecord record) throws Throwable {

        transferService.transfer(record.getFromAccountId(),
                record.getToAccountId(),
                record.getAmount());

        return ResponseEntity.ok("DONE");
    }
}

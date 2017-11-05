package ua.ali_x.checkmymoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.ali_x.checkmymoney.model.Transaction;
import ua.ali_x.checkmymoney.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction)
                .map(ResponseEntity.status(201)::body)
                .orElseGet(ResponseEntity.status(418)::build);
    }

}

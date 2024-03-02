package com.agile.interview.bankingApp.controller;

import com.agile.interview.bankingApp.dto.TransactionDTO;
import com.agile.interview.bankingApp.utils.enums.TransactionStatus;
import com.agile.interview.bankingApp.utils.exception.BusinessValidationException;
import com.agile.interview.bankingApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    @ResponseBody
    private ResponseEntity<String> transferMoney(@RequestBody TransactionDTO transactionDTO) {

        try {
            transactionService.transferAmount(transactionDTO);
        } catch (BusinessValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(TransactionStatus.SUCCESS.getMessage());
    }
}

package com.agile.interview.bankingApp.mapper;

import com.agile.interview.bankingApp.dto.TransactionDTO;
import com.agile.interview.bankingApp.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction dtoToModel(TransactionDTO dto);
}

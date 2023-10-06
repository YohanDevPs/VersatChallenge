package service;

import dtos.TransactionFilterDTO;
import entities.TotalBalance;
import entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransationService {

        public TotalBalance getTotalBalance(List<Transaction> transactions) {

            return new TotalBalance();
        }
}

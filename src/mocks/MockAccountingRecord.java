package mocks;

import enums.ConceptType;
import entities.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockAccountingRecord {

    private static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
    private static double getRandomDouble(int min, int max) {
        return new Random().nextDouble(max - min);
    }

    public static List<Transaction> accountRecordList() {
        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            transactions.add(
                    new Transaction(LocalDateTime.of(
                        getRandomInt(2000, 2023),
                        getRandomInt(1, 13),
                        getRandomInt(1, 29),
                        getRandomInt(0, 24),
                        getRandomInt(0, 60),
                        getRandomInt(0, 60)
                        ),
                    i % 2 == 0 ? ConceptType.PROPERTY : ConceptType.BONUSES ,
                    new BigDecimal(getRandomDouble(100, 3000)).setScale(2, RoundingMode.HALF_DOWN)));
        }

        return transactions;
    }
}

package mocks;

import entities.AccountRecord;
import enums.ConceptType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MockAccountingRecord {

    private static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
    private static double getRandomDouble(int min, int max) {
        return new Random().nextDouble(max - min);
    }

    public static Set<AccountRecord> accountRecordList() {
        Set<AccountRecord> accountRecords = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            accountRecords.add(
                    new AccountRecord(LocalDateTime.of(
                        getRandomInt(2022, 2023),
                        getRandomInt(1, 13),
                        getRandomInt(1, 29),
                        getRandomInt(0, 24),
                        getRandomInt(0, 60),
                        getRandomInt(0, 60)
                        ),
                    i % 2 == 0 ? ConceptType.BILL_TO_PAY : ConceptType.PROPERTY ,
                    new BigDecimal(getRandomDouble(100, 3000)).setScale(2, RoundingMode.HALF_DOWN)));
        }

        return accountRecords;
    }
}

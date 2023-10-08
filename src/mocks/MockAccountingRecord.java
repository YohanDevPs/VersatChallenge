package mocks;

import entities.AccountRecord;
import enums.ConceptType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MockAccountingRecord {

    public static Set<AccountRecord> generateAccountRecords() {
        Set<AccountRecord> accountRecords = new HashSet<>();

        for (int i = 0; i < 100000; i++) {
            AccountRecord record = new AccountRecord();
            record.setData(generateRandomDate());
            record.setConceptType(generateRandomConceptType());
            record.setAmount(generateRandomAmount());
            accountRecords.add(record);
        }

        return accountRecords;
    }

    private static LocalDate generateRandomDate() {
        long startEpochDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long endEpochDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static ConceptType generateRandomConceptType() {
        ConceptType[] values = ConceptType.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(values.length);
        return values[randomIndex];
    }

    private static BigDecimal generateRandomAmount() {
        return BigDecimal
                .valueOf(ThreadLocalRandom.current().nextDouble(1, 1000))
                .setScale(2, RoundingMode.HALF_DOWN);
    }
}

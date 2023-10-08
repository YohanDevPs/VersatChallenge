package entities;

import enums.ConceptType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountRecord {
    private LocalDate data;
    private ConceptType conceptType;
    private BigDecimal amount;

    public AccountRecord(LocalDate data, ConceptType conceptType, BigDecimal amount) {
        this.data = data;
        this.conceptType = conceptType;
        this.amount = amount;
    }

    public AccountRecord() {

    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ConceptType getConceptType() {
        return conceptType;
    }

    public void setConceptType(ConceptType conceptType) {
        this.conceptType = conceptType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction:" +
                " data: " + data +
                ", conceptType:" + conceptType +
                ", amount:" + amount;
    }
}

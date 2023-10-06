package entities;

import enums.ConceptType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime data;
    private ConceptType conceptType;
    private BigDecimal amount;

    public Transaction(LocalDateTime data, ConceptType conceptType, BigDecimal amount) {
        this.data = data;
        this.conceptType = conceptType;
        this.amount = amount;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
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

package dtos;

import enums.ConceptType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionFilterDTO(LocalDateTime startDate,
                                   LocalDateTime endDate,
                                   ConceptType conceptType,
                                   BigDecimal minAmount,
                                   BigDecimal maxAmount) {

}

package br.com.farmproductivity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionDocument {

    private String description;
    private BigDecimal amount;

    private LocalDateTime initialDate;
    private LocalDateTime finalDate;

    private Integer periodicity;

}

package br.com.lucas.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrasNew {

    private String name;
    private String  description;
    private BigDecimal daily_rate;
    private String license_plate;
    private Integer brand;
    private Integer category;
    private String color;
}

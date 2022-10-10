package br.com.lucas.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rentais {


    private Integer id;

    private Cras cras;
    private Costumers costumer;
    private String start_date;
    private String end_date;
    private BigDecimal total;
    private Date created_at;
    private Date update_at;


}

package br.com.lucas.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentaisNew {


    private Integer cras;
    private Integer costumer;
    private String start_date;
    private long numberOfDaysRentals;


}

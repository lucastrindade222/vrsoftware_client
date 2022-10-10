package br.com.lucas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckAvailability {

    private String start_date;
    private Long numberOfDaysRentals;

}

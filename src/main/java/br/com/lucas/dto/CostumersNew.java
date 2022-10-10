package br.com.lucas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostumersNew {

     
    private String name;
    private String birth_date;
    private String email;
    private String driver_license;
    private String adress;
    private String phone_number;



}

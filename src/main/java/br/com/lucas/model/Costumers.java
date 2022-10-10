package br.com.lucas.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumers {


    private Integer id;
    private String name;
    private String birth_date;
    private String email;
    private String driver_license;
    private String adress;
    private String phone_number;
    private Date created_at;
    private Date update_at;

    List<Rentais> rentais;

}

package br.com.lucas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsImages {

    private Integer id;
    private Date created_at;
    private Cras car;
    private String image;

}

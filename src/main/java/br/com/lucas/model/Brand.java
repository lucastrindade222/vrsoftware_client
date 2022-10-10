package br.com.lucas.model;


import lombok.*;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand  {



    private Integer id;
    private String name;
    private Date created_at;

    private List<Cras> crasList;

}

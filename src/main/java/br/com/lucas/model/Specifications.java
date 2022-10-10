package br.com.lucas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specifications {


    private Integer id;
    private String name;
    private String description;
    private Date created_at;
    private Set<Cras> cras;
}

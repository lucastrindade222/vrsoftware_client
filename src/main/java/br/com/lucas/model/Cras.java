package br.com.lucas.model;


import br.com.lucas.view.ImaCarros;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cras {


  private Integer id;
  private String name;
  private String  description;
  private BigDecimal daily_rate;
  private boolean available;
  private String license_plate;

  private Brand brand;

  private Category category;
  private String color;
  private Date created_at;

  private List<Rentais> rentais;
  private CarsImages carsImages;
  private Set<Specifications> specifications;




}

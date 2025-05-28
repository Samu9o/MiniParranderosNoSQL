package uniandes.edu.co.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data; @Data
@Document(collection = "EPS")
public class EPS {
  @Id              private String idEPS;
                    private String nombre;
                    private String direccion;
                    private String telefono;
}
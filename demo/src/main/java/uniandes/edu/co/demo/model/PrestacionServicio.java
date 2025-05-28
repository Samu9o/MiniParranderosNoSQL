// PrestacionServicio.java
package uniandes.edu.co.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data; @Data
@Document(collection = "prestacionServicio")
public class PrestacionServicio {
  @Id              private String idPrestacion;
                    private String idServicio;
                    private String idMédico;
                    private String idIPS;
                    private String horario;          // ej. "08:00-12:00"
                    private int    cuposDisponibles;
}

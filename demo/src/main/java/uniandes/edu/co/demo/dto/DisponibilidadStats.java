// DisponibilidadStats.java
package uniandes.edu.co.demo.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadStats {
    private String servicioNombre;
    private LocalDateTime fechaHora;
    private String ipsNombre;
    private String medicoNombre;
}

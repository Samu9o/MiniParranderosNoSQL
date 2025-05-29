// ServicioSolicitadoStats.java
package uniandes.edu.co.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioSolicitadoStats {
    private String servicioId;
    private String servicioNombre;
    private long total;
}

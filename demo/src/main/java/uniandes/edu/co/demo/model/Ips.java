// src/main/java/uniandes/edu/co/demo/model/Ips.java
package uniandes.edu.co.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data; import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor
@Document(collection = "ips")
public class Ips {
    @Id         private ObjectId id;
    @NotBlank   private String   nombre;
    @NotBlank   private String   nit;
                private String   direccion;
                private String   telefono;
}

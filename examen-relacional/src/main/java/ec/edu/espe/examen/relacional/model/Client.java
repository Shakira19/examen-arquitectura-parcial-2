
package ec.edu.espe.examen.relacional.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author cofre
 */
@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cliente")
public class Client {
    @Id
    @Column(name = "cedula", length = 10)
    private String id;
    
    @Column(name = "nombre", length = 100)
    private String name;
    
    @Column(name = "direcion", length = 100)
    private String address;
    
    @Column(name = "telefono", length = 16)
    private String phone;
    
    @Column(name = "correo", length = 100)
    private String email;
}

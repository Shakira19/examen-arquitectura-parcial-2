
package ec.edu.espe.examen.relacional2.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="producto")
public class Product {
    @Id
    @Column(name = "cod_producto", length = 8)
    private String id;
    
    @Column(name = "nombre", length = 120)
    private String name;
    
    @Column(name = "existencia", length = 7)
    private Integer existence;
    
    @Column(name = "valor_unitario", length = 10, precision = 2)
    private BigDecimal unitaryPrice;
    
    @Column(name = "aplica_iva")
    private String appliesIva;
}

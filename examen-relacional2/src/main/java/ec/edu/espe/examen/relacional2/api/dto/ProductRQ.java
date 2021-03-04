
package ec.edu.espe.examen.relacional2.api.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author cofre
 */
@Data
public class ProductRQ {
    private String id;
    private String name;
    private Integer existence;
    private BigDecimal unitaryPrice;
    private String appliesIva;
}


package ec.edu.espe.examen.relacional.api.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author cofre
 */
@Data
public class FacturaClienteRQ {
    private Date fecha;
    private String idCliente;
}


package ec.edu.espe.examen.nosql.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author cofre
 */
@Data
@Builder
@Document(collection = "factura")
public class Invoice {
    @Id
    private String id;
    private Date date;
    private BigDecimal total;
    private String idClient;
    private BigDecimal tax;
    private List<InvoiceDetail> detail;
}

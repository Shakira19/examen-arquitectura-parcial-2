
package ec.edu.espe.examen.nosql.model;

import java.math.BigDecimal;
import java.util.Date;
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
@Document(collection = "invoiceDetail")
public class InvoiceDetail {
    @Id
    private String id;
    private String idInvoice;
    private BigDecimal subtotal;
    private Integer quantity;
    private String idProduct;
}

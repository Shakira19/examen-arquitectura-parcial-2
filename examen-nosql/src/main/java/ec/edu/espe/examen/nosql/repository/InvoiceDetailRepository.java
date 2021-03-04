
package ec.edu.espe.examen.nosql.repository;


import ec.edu.espe.examen.nosql.model.InvoiceDetail;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author cofre
 */
public interface InvoiceDetailRepository {
    List<InvoiceDetail> findAll();
    Optional <InvoiceDetail> findById(String id);
}

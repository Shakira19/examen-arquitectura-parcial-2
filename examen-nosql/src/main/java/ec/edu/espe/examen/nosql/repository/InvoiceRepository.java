
package ec.edu.espe.examen.nosql.repository;

import ec.edu.espe.examen.nosql.model.Invoice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cofre
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String>{
    List<Invoice> findAll();
    
    Optional <Invoice> findById(String id);
}

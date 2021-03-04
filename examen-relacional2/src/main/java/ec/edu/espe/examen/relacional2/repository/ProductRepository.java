
package ec.edu.espe.examen.relacional2.repository;


import ec.edu.espe.examen.relacional2.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cofre
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    List<Product> findAll();
    Optional<Product> findById(String id);
    
}

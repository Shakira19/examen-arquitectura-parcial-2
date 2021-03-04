
package ec.edu.espe.examen.relacional2.service;

import ec.edu.espe.examen.relacional2.exception.InsertException;
import ec.edu.espe.examen.relacional2.exception.NotFoundException;
import ec.edu.espe.examen.relacional2.exception.RegistryNotFoundException;
import ec.edu.espe.examen.relacional2.exception.UpdateException;
import ec.edu.espe.examen.relacional2.model.Product;
import ec.edu.espe.examen.relacional2.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author cofre
 */
@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepo;
    
    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }
    
    public List<Product> getAllProducts() throws RegistryNotFoundException{
        List<Product> products = this.productRepo.findAll();
       if(!products.isEmpty()) {
           return products;
       } else {
           throw new RegistryNotFoundException("There is no content in products table");
       }
       
    }
    
    public Product getProductById(String id) throws RegistryNotFoundException{
        Optional<Product> product = this.productRepo.findById(id);
        if(product.isPresent()){
            return product.get();
        }else{
            log.info("The product with id: {} does not exists", product);
            throw new RegistryNotFoundException("The product with id" +product+ "does not exists");
        }
    }
    
    public void createProduct(Product product) throws InsertException{
        try {
            this.productRepo.save(product);
        } catch (Exception e) {
            throw new InsertException("product", "Couldn't insert product: "+product.toString(), e);
        }
        
    }
    
    public void updateProduct( String id, Product product) throws UpdateException {
        Optional<Product> searchedProduct = this.productRepo.findById(id);
        if(searchedProduct.isPresent()) {
            Product updatedProduct = searchedProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setExistence(product.getExistence());
            updatedProduct.setAppliesIva(product.getAppliesIva());
            updatedProduct.setUnitaryPrice(product.getUnitaryPrice());
            try {
                this.productRepo.save(product);
            } catch (Exception e) {
                log.error("The product with id {} couldn't not update",id);
                throw new UpdateException("product", "Couldn't update product with id "+id);
            }
        } else {
            log.error("El producto con id {} no se pudo encontrar");
            throw new NotFoundException("The product with id " +id+" was not found");
        }
    }
    
}


package ec.edu.espe.examen.relacional2.api;

import ec.edu.espe.examen.relacional2.api.dto.ProductRQ;
import ec.edu.espe.examen.relacional2.exception.InsertException;
import ec.edu.espe.examen.relacional2.exception.NotFoundException;
import ec.edu.espe.examen.relacional2.exception.RegistryNotFoundException;
import ec.edu.espe.examen.relacional2.exception.UpdateException;
import ec.edu.espe.examen.relacional2.model.Product;
import ec.edu.espe.examen.relacional2.service.ProductService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cofre
 */
@CrossOrigin
@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {
    private final ProductService service;
    
    public ProductController(ProductService service){
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> listProduct() {
        try {
            log.info("All products were listed");
            return ResponseEntity.ok(this.service.getAllProducts());
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
    
    @GetMapping("/search/{id}")
    public ResponseEntity<Product> listProductById(String id) {
        try {
            log.info("Product by code was listed");
            return ResponseEntity.ok(this.service.getProductById(id));
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity creatProduct(@RequestBody ProductRQ product){
        try {
            log.info("Product created");
            this.service.createProduct(Product.builder()
                                        .id(product.getId())
                                        .name(product.getName())
                                        .existence(product.getExistence())
                                        .unitaryPrice(product.getUnitaryPrice())
                                        .appliesIva(product.getAppliesIva()).build());
            return ResponseEntity.ok().build();
        } catch (InsertException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody ProductRQ product) {
        try {
            this.service.updateProduct(id, Product.builder()
                                                       .id(product.getId())
                                                       .name(product.getName())
                                                       .existence(product.getExistence())
                                                       .unitaryPrice(product.getUnitaryPrice())
                                                       .appliesIva(product.getAppliesIva()).build());
            log.info("The product has been updated");
            return ResponseEntity.ok().build();
        } catch (UpdateException e) {
            return ResponseEntity.badRequest().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

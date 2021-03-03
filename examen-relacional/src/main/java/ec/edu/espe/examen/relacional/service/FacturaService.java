
package ec.edu.espe.examen.relacional.service;

import ec.edu.espe.examen.relacional.exception.RegistryNotFoundException;
import ec.edu.espe.examen.relacional.repository.ClienteRepository;
import ec.edu.espe.examen.relacional.repository.FacturaRepository;
import ec.edu.espe.examen.relacional.model.Factura;
import ec.edu.espe.examen.relacional.model.Cliente;
import java.util.Date;
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
public class FacturaService {
  
    private final FacturaRepository facturaRepo;
    private final ClienteRepository clienteRepo;

    public FacturaService(FacturaRepository facturaRepo, ClienteRepository clienteRepo){
        this.clienteRepo = clienteRepo;
        this.facturaRepo = facturaRepo;
    }
    
    public List<Factura> listarFactura(){
        return this.facturaRepo.findAll();
    }

    public List<Factura> getFacturaByIdLike(Integer id) throws RegistryNotFoundException{
        List<Factura> result = facturaRepo.findByIdLike(id);
        if(result.isEmpty()){
            log.info("The factura with id: {} was not found", id);
            throw new RegistryNotFoundException("The factura with name" +id+ "was not found");
        }else{
            return result;
        }
    }
    
    public Factura getFacturaById(Integer id) throws RegistryNotFoundException{
        Optional<Factura> factura = this.facturaRepo.findById(id);
        if(factura.isPresent()){
            return factura.get();
        }else{
            log.info("The factura with id: {} does not exists", id);
            throw new RegistryNotFoundException("The factura with id" +id+ "does not exists");
        }
    }
    
    public List<Factura> getFacturaByFecha(Date date) throws RegistryNotFoundException{
        List<Factura> result=this.facturaRepo.findByFecha(date);
        if(result.isEmpty()){
            log.info("The factura with date: {} was not found", date);
            throw new RegistryNotFoundException("The factura with date" +date+ "was not found");
        }else{
            return result;
        }
    }
    
    public List<Factura> getFacturaByCliente(Integer id) throws RegistryNotFoundException{
        Optional<Cliente> cliente = this.clienteRepo.findById(id);
        if(cliente.isPresent()){
           List<Factura> result = this.facturaRepo.findByCliente(cliente.get());
           if(result.isEmpty()){
                log.info("The facturas with client id: {} was not found ", id);
                throw new RegistryNotFoundException("The factura with client id " +id+ " was not found");
            }else{
                return result;
            }
        }else{
            log.info("The client with id: {} does not exists", id);
            throw new RegistryNotFoundException("The client with id" +id+ "does not exists");
        }
        
    }
}

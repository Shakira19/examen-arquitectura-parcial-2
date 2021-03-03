
package ec.edu.espe.examen.relacional.service;

import ec.edu.espe.examen.relacional.exception.InsertException;
import ec.edu.espe.examen.relacional.repository.ClienteRepository;
import ec.edu.espe.examen.relacional.model.Cliente;
import ec.edu.espe.examen.relacional.exception.NotFoundException;
import ec.edu.espe.examen.relacional.exception.RegistryNotFoundException;
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
public class ClienteService {
    private final ClienteRepository clienteRepo;
    
    public ClienteService(ClienteRepository clienteRepo){
        this.clienteRepo = clienteRepo;
    }
    
    public List<Cliente> listarClientes() throws RegistryNotFoundException{
        List<Cliente> clientes = this.clienteRepo.findAll();
       if(!clientes.isEmpty()) {
           return clientes;
       } else {
           throw new RegistryNotFoundException("There is no content in clients table");
       }
       
    }
    
    public Cliente getClienteById(Integer id) throws RegistryNotFoundException{
        Optional<Cliente> cliente = this.clienteRepo.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }else{
            log.info("The client with id: {} does not exists", id);
            throw new RegistryNotFoundException("The client with id" +id+ "does not exists");
        }
    }
    
    public List<Cliente> getClientByName(String name) throws RegistryNotFoundException{
        List<Cliente> result=this.clienteRepo.findByNameLikeIgnoreCaseOrderByNameAsc(name);
        if(result.isEmpty()){
            log.info("The client with name: {} was not found", name);
            throw new RegistryNotFoundException("The client with name" +name+ "was not found");
        }else{
            return result;
        }
    }
    
    public List<Cliente> getClientBySurname(String surname) throws RegistryNotFoundException{
        List<Cliente> result=this.clienteRepo.findBySurnameLikeIgnoreCaseOrderBySurnameAsc(surname);
        if(result.isEmpty()){
            log.info("The client with surname: {} was not found", surname);
            throw new RegistryNotFoundException("The client with name" +surname+ "was not found");
        }else{
            return result;
        }
    }
    
    public List<Cliente> getClienteByCedula(String cedula) throws RegistryNotFoundException{
        List<Cliente> result=this.clienteRepo.findByCedulaLike(cedula);
        if(result.isEmpty()){
            log.info("The client with identification: {} was not found", cedula);
            throw new RegistryNotFoundException("The client with identification" +cedula+ "was not found");
        }else{
            return result;
        }
    }
    
    public void createCliente(Cliente cliente) throws InsertException{
        Cliente savedCliente = this.clienteRepo.save(cliente);
        if(savedCliente == null) {
            throw new InsertException("cliente", "Couldn't insert client");
        }
    }
    
}

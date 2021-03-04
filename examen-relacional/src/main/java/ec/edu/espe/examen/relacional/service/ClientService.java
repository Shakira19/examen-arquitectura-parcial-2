
package ec.edu.espe.examen.relacional.service;

import ec.edu.espe.examen.relacional.exception.InsertException;
import ec.edu.espe.examen.relacional.model.Client;
import ec.edu.espe.examen.relacional.exception.NotFoundException;
import ec.edu.espe.examen.relacional.exception.RegistryNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ec.edu.espe.examen.relacional.repository.ClientRepository;

/**
 *
 * @author cofre
 */
@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepo;
    
    public ClientService(ClientRepository clientRepo){
        this.clientRepo = clientRepo;
    }
    
    public List<Client> getAllClients() throws RegistryNotFoundException{
        List<Client> clients = this.clientRepo.findAll();
       if(!clients.isEmpty()) {
           return clients;
       } else {
           throw new RegistryNotFoundException("There is no content in clients table");
       }
       
    }
    
    public Client getClientById(String id) throws RegistryNotFoundException{
        Optional<Client> client = this.clientRepo.findById(id);
        if(client.isPresent()){
            return client.get();
        }else{
            log.info("The client with identification: {} does not exists", id);
            throw new RegistryNotFoundException("The client with identification" +id+ "does not exists");
        }
    }
    
    public void createClient(Client client) throws InsertException{
        Client savedClient = this.clientRepo.save(client);
        if(savedClient == null) {
            throw new InsertException("client", "Couldn't insert client");
        }
    }
    
}


package ec.edu.espe.examen.relacional.api;

import ec.edu.espe.examen.relacional.exception.RegistryNotFoundException;
import ec.edu.espe.examen.relacional.model.Client;
import ec.edu.espe.examen.relacional.service.ClientService;
import ec.edu.espe.examen.relacional.api.dto.ClientRQ;
import ec.edu.espe.examen.relacional.exception.InsertException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cofre
 */
@CrossOrigin
@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {
    private final ClientService service;
    
    public ClientController(ClientService service){
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Client>> listClient() {
        try {
            log.info("All clients were listed");
            return ResponseEntity.ok(this.service.getAllClients());
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
    
    @GetMapping("/search/{id}")
    public ResponseEntity<Client> listClientById(String id) {
        try {
            log.info("Client by identification was listed");
            return ResponseEntity.ok(this.service.getClientById(id));
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity creatClient(@RequestBody ClientRQ client){
        try {
            log.info("Client created");
            this.service.createClient(Client.builder()
                                        .id(client.getId())
                                        .name(client.getName())
                                        .address(client.getAddress())
                                        .phone(client.getPhone())
                                        .email(client.getEmail()).build());
            return ResponseEntity.ok().build();
        } catch (InsertException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}


package ec.edu.espe.examen.relacional.api;

import ec.edu.espe.examen.relacional.exception.RegistryNotFoundException;
import ec.edu.espe.examen.relacional.model.Cliente;
import ec.edu.espe.examen.relacional.service.ClienteService;
import ec.edu.espe.examen.relacional.api.dto.ClienteRQ;
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
@RequestMapping("/api/cliente")
@Slf4j
public class ClienteController {
    private final ClienteService service;
    
    public ClienteController(ClienteService service){
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        try {
            log.info("All clients were listed");
            return ResponseEntity.ok(this.service.listarClientes());
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity crearCliente(@RequestBody ClienteRQ cliente){
        try {
            log.info("Client created");
            this.service.createCliente(Cliente.builder()
                                        .name(cliente.getName())
                                        .surname(cliente.getSurname())
                                        .cedula(cliente.getCedula()).build());
            return ResponseEntity.ok().build();
        } catch (InsertException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}

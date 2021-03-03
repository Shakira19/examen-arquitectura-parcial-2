
package ec.edu.espe.examen.relacional.api;

import ec.edu.espe.examen.relacional.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class FacturaController {
    private final FacturaService service;
    
    public FacturaController(FacturaService service){
        this.service=service;
    }
}

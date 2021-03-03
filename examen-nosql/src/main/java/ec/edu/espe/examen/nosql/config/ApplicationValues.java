
package ec.edu.espe.examen.nosql.config;

import lombok.Getter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cofre
 */
@Component
@Getter
public class ApplicationValues {
    
    private final String mongoHost;
    private final String mongoDB;

    @Autowired
    public ApplicationValues(@org.springframework.beans.factory.annotation.Value("${personas.mongo.host}") String mongoHost, @org.springframework.beans.factory.annotation.Value("${personas.mongo.db}") String mongoDB) {
        this.mongoHost = mongoHost;
        this.mongoDB = mongoDB;
    }
    
    
}
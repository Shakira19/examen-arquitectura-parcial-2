/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.examen.relacional.model.Client;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author cofre
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{
    
    List<Client> findAll();
    Optional<Client> findById(String id);
}

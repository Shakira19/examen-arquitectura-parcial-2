/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.examen.relacional.model.Cliente;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author cofre
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    List<Cliente> findByNameLikeIgnoreCaseOrderByNameAsc(String name);
    List<Cliente> findBySurnameLikeIgnoreCaseOrderBySurnameAsc(String surname);
    List<Cliente> findByCedulaLike(String cedula);
}

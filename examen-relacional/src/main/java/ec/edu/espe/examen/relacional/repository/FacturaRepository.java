/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.relacional.repository;

import java.util.List;
import ec.edu.espe.examen.relacional.model.Factura;
import ec.edu.espe.examen.relacional.model.Cliente;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author cofre
 */
public interface FacturaRepository extends JpaRepository<Factura,Integer>{
    List<Factura> findAll();
    List<Factura> findByIdLike(Integer id);
    Optional<Factura> findById(Integer id);
    List<Factura> findByFecha(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") Date fecha);
    List<Factura> findByCliente(Cliente cliente);
}

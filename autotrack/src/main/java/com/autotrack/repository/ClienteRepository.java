package com.autotrack.repository;

import com.autotrack.domain.Cliente;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Cliente c SET c.activo = false WHERE c.idCliente = :idCliente")
    void borrarLogicamente(@Param("idCliente") Integer idCliente);
}

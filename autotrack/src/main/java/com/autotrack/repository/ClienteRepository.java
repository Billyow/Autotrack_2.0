package com.autotrack.repository;

import com.autotrack.domain.Cliente;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.documento = :documento")
    Cliente findClienteByDocumento(@Param("documento") String documento);
}

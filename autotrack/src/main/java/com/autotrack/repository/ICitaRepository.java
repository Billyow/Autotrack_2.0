package com.autotrack.repository;

import com.autotrack.domain.Cita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICitaRepository  extends CrudRepository<Cita,Long> {

    @Query("SELECT c FROM Cita c WHERE c.cliente.documento like %:documento%")
    List<Cita> findCitasByDocumentoCliente(@Param("documento") String documento);

    Cita findByFechaCita(@Param("date") Date fechaCita);

}

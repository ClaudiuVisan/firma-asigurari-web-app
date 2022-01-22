package com.example.firma_asigurari.Agenti;

import org.springframework.data.repository.CrudRepository;

public interface AgentiRepository extends CrudRepository<Agenti, Integer> {
    public Long countById(Integer id);
}

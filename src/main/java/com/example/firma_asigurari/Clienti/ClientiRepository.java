package com.example.firma_asigurari.Clienti;

import org.springframework.data.repository.CrudRepository;

public interface ClientiRepository extends CrudRepository<Clienti, Integer> {
    public Long countById(Integer id);
}

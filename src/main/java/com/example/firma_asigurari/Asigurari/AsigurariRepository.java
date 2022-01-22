package com.example.firma_asigurari.Asigurari;

import org.springframework.data.repository.CrudRepository;

public interface AsigurariRepository extends CrudRepository<Asigurari, Integer> {
    public Long countById(Integer id);
}

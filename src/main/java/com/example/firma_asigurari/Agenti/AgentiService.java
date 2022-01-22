package com.example.firma_asigurari.Agenti;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgentiService {
    @Autowired
    private AgentiRepository repo;

    public List<Agenti> listAll() {
        return (List<Agenti>) repo.findAll();
    }

    public void save(Agenti catalogue) {
        repo.save(catalogue);
    }

    public Agenti get(Integer id){
        Optional<Agenti> result= repo.findById(id);
        return result.get();
       
    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        repo.deleteById(id);
    }
}

package com.example.firma_asigurari.Asigurari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AsigurariService {
    @Autowired
    private AsigurariRepository repo;

    public List<Asigurari> listAll() {
        return (List<Asigurari>) repo.findAll();
    }

    public void save(Asigurari catalogue) {
        repo.save(catalogue);
    }

    public Asigurari get(Integer id){
        Optional<Asigurari> result= repo.findById(id);
        return result.get();
    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        repo.deleteById(id);
    }
}

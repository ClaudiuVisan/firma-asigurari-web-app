package com.example.firma_asigurari.Clienti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientiService {
    @Autowired
    private ClientiRepository repo;

    public List<Clienti> listAll() {
        return (List<Clienti>) repo.findAll();
    }

    public void save(Clienti composer) {
        repo.save(composer);
    }

    public Clienti get(Integer id){
        Optional<Clienti> result= repo.findById(id);
        return result.get();

    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        repo.deleteById(id);
    }
}

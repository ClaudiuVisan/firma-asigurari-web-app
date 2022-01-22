package com.example.firma_asigurari.Clienti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller

public class ClientiController {
    @Autowired
    private ClientiService service;

    @GetMapping("/clienti")
    public String showClientiList(Model model){
        List<Clienti> clientiList = service.listAll();
        model.addAttribute("clientiList", clientiList);

        return "clienti";
    }

    @GetMapping("/clienti/adaugare")
    public String showNewForm(Model model) {
        model.addAttribute("client", new Clienti());

        return "clientAdd";
    }

    @PostMapping("/clienti/save")
    public String saveUser(Clienti client) {
        service.save(client);

        return "redirect:/clienti";
    }

    @GetMapping("/clienti/editare/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {

            Clienti client = service.get(id);
            model.addAttribute("client",client);
            return  "clientEdit";
    }

    @GetMapping("/clienti/stergere/{id}")
    public String deleteClienti(@PathVariable("id") Integer id){
        service.delete(id);

        return "redirect:/clienti";
    }
}

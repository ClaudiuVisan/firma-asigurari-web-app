package com.example.firma_asigurari.Asigurari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AsigurariController {
    @Autowired
    private AsigurariService service;

    @GetMapping("/asigurari")
    public String showAsigurariList(Model model){
        List<Asigurari> asigurariList = service.listAll();
        model.addAttribute("asigurariList", asigurariList);

        return "asigurari";
    }

    @GetMapping("/asigurari/adaugare")
    public String showNewForm(Model model) {
        model.addAttribute("asigurare", new Asigurari());
        return "asigurareAdd";
    }

    @PostMapping("/asigurari/save")
    public String saveUser(Asigurari asigurare) {
        service.save(asigurare);

        return "redirect:/asigurari";
    }

    @GetMapping("/asigurari/editare/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
            Asigurari asigurare = service.get(id);
            model.addAttribute("asigurare",asigurare);
            return  "asigurareEdit";
        
    }

    @GetMapping("/asigurari/stergere/{id}")
    public String deleteAsigurari(@PathVariable("id") Integer id){
        service.delete(id);

        return "redirect:/asigurari";
    }
}

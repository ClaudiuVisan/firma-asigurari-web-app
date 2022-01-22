package com.example.firma_asigurari.Agenti;

import com.example.firma_asigurari.Asigurari.Asigurari;
import com.example.firma_asigurari.Asigurari.AsigurariService;
import com.example.firma_asigurari.Clienti.Clienti;
import com.example.firma_asigurari.Clienti.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AgentiController {
    @Autowired
    private AgentiService service;

    @Autowired
    private AsigurariService asigurariService;

    @Autowired
    private ClientiService clientiService;

    @GetMapping("/agenti")
    public String showAgentiList(Model model){
        List<Agenti> agentiList = service.listAll();
        model.addAttribute("agentiList", agentiList);

        return "agenti";
    }

    @GetMapping("/agenti/adaugare")
    public String showNewForm(Model model) {
        List<Asigurari> asigurariList = asigurariService.listAll();
        List<Clienti> clientiList = clientiService.listAll();
        model.addAttribute("agent", new Agenti());
        model.addAttribute("asigurariList",asigurariList);
        model.addAttribute("clientiList",clientiList);

        return "agentAdd";
    }

    @PostMapping("/agenti/save")
    public String saveUser(Agenti agent) {
        service.save(agent);

        return "redirect:/agenti";
    }

    @GetMapping("/agenti/editare/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Agenti agent = service.get(id);
        List<Asigurari> asigurariList = asigurariService.listAll();
        List<Clienti> clientiList = clientiService.listAll();
        model.addAttribute("agent",agent);
        model.addAttribute("asigurariList",asigurariList);
        model.addAttribute("clientiList",clientiList);

            return  "agentEdit";

    }

    @GetMapping("/agenti/stergere/{id}")
    public String deleteAgenti(@PathVariable("id") Integer id){
        service.delete(id);

        return "redirect:/agenti";
    }
}

package com.example.demo.model.ws;

import com.example.demo.model.bean.Commande;
import com.example.demo.model.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("commande-api/commande")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;


    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/reference/{reference}")
    @Cacheable(value="commande", key="#reference")
    public Commande findByReference(@PathVariable String reference) {
       return commandeService.findByReference(reference);
    }
    @GetMapping("/id/{id}")
    @Cacheable(value="commande", key="#id", unless = "#result.id>2")
    public Optional<Commande> findById(@PathVariable Long id) {
       return commandeService.findById(id);
    }
    @GetMapping("/montant/{montant}")
    public List<Commande> findByMontant(@PathVariable BigDecimal montant) {
        return commandeService.findByMontant(montant);
    }
    @PostMapping("/")
    public void save(@RequestBody Commande commande) {
        commandeService.save(commande);
    }


}

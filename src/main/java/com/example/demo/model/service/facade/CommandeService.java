package com.example.demo.model.service.facade;


import com.example.demo.model.bean.Commande;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {
    public Commande findByReference(String reference);
    public List<Commande> findByMontant(BigDecimal montant);
    public Optional<Commande> findById(Long id);
    public Commande save(Commande commande);
    public List<Commande> findAll();


}

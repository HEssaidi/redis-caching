package com.example.demo.model.dao;

import com.example.demo.model.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeDao extends JpaRepository <Commande, Long>{
    public Commande findByReference(String reference);
    public List<Commande> findByMontant(BigDecimal montant);
//    public Optional<Commande> findById(Long id);
    public Commande save(Commande commande);
    public List<Commande> findAll();
}

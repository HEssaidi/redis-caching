package com.example.demo.model.service.Impl;

import com.example.demo.model.bean.Commande;
import com.example.demo.model.dao.CommandeDao;
import com.example.demo.model.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeImpl implements CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public Commande save(Commande commande) {
        return commandeDao.save(commande);
    }

    public Commande findByReference(String reference) {
        Optional opt = Optional.ofNullable(commandeDao.findByReference(reference));
        System.out.println(opt.isPresent() + " ****** " +commandeDao.findByReference(reference));
        if (opt.isPresent()){
            return commandeDao.findByReference(reference);
        }
        return null;
    }

    public List<Commande> findByMontant(BigDecimal montant) {
        return commandeDao.findByMontant(montant);
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeDao.findById(id);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    public void deleteById(Long id) {
        commandeDao.deleteById(id);
    }



}

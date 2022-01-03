package com.example.demo;

import com.example.demo.model.bean.Commande;
import com.example.demo.model.dao.CommandeDao;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	public CommandeDao commandeDao;

	/*@Test
	public void cmdCreation() {
		Commande commande= new Commande();
		commande.setId(12L);
		commande.setReference("ref-12");
		commande.setMontant(125);
		commandeDao.save(commande);
		assertNotNull(commandeDao.findById(1L).get());


	}*/
	@Test
	public void cmdList() {
		List<Commande> list = commandeDao.findAll();
		assertEquals(list.size(), 2);
	}
	@Test
	public void cmdVerif() {
		Commande cmds = commandeDao.findByReference("ref-30");
//		Commande cmd = commandeDao.findByReference("ref-12");

//		String name = "baeldung";
		Optional opt = Optional.ofNullable(cmds);
		assertTrue(opt.isPresent());
//			assertEquals("ref-12", cmds.getReference());
//			System.out.println(é);
	}
	/*@Test
	public void cmdDelete() {
		commandeDao.deleteById(4L);
		assertEquals("ref-12", cmds.getReference());
//		Commande cmd = commandeDao.findByReference("ref-12");

//			System.out.println(é);
	}*/

}

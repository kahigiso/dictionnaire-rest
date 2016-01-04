package net.francais.mashi.dic.services;

import net.francais.mashi.dic.entities.Domaine;
import net.francais.mashi.dic.repositories.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class DomaineService {

	@Autowired
	private DomaineRepository domaineRepository;
	
	
	public Domaine createOrUpdate(Domaine domaine) {
		return domaineRepository.save(domaine);
	}
	
	public Domaine findByName(String name) {
		return domaineRepository.findByName(name);
	}
	
}

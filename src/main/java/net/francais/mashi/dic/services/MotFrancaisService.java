package net.francais.mashi.dic.services;

import net.francais.mashi.dic.entities.MotFrancais;
import net.francais.mashi.dic.repositories.MotFrancaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MotFrancaisService {

	
	@Autowired
	private MotFrancaisRepository motFrancaisRepository;
	
	
	public MotFrancais createOrUpdate(MotFrancais motFrancais) {
		return motFrancaisRepository.save(motFrancais);
	}
	
	public MotFrancais findByMot(String mot){
		return motFrancaisRepository.findByMot(mot);
	}
	
	public MotFrancais findByMotAndPrecizion(String mot, String precizion){
		return motFrancaisRepository.findByMotAndPrecizion(mot,precizion);
	}

}

package net.francais.mashi.dic.services;

import net.francais.mashi.dic.entities.MotMashi;
import net.francais.mashi.dic.repositories.MotMashiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MotMashiService {

	@Autowired
	private MotMashiRepository motMashiRepository;
	
	public MotMashi createOrUpdate(MotMashi motMashi) {
		return motMashiRepository.save(motMashi);
	}
	
	//For data initialization purpose only
	public MotMashi findByMot(String mot){
		return motMashiRepository.findByMot(mot);
	}
	
}

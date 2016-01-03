package net.francais.mashi.dic.services;

import net.francais.mashi.dic.entities.Example;
import net.francais.mashi.dic.repositories.ExampleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ExampleService {

	
	@Autowired
	private ExampleRepository exampleRepository;
	
	
	public Example createOrUpdate(Example example) {
		return exampleRepository.save(example);
	}
	
}

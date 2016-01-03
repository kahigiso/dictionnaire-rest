package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.LangueOrigine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LangueOrigineRepository extends JpaRepository<LangueOrigine, Integer>{

	LangueOrigine findByName(String name);

}

package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.Domaine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine,Integer>{

	Domaine findByName(String name);

}

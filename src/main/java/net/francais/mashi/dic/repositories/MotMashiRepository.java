package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.MotMashi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotMashiRepository extends JpaRepository<MotMashi, Integer>{

	MotMashi findByMot(String mot);

}

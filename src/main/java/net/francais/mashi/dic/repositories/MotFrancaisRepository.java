package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.MotFrancais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotFrancaisRepository extends JpaRepository<MotFrancais, Long>{

	MotFrancais findByMot(String mot);

}

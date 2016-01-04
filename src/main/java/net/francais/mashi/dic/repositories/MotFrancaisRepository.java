package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.Domaine;
import net.francais.mashi.dic.entities.MotFrancais;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotFrancaisRepository extends JpaRepository<MotFrancais, Long>{

	MotFrancais findByMot(String mot);
	List<MotFrancais> findByDomaine(Domaine domaine);
	MotFrancais findByMotAndPrecizion(String mot,String precizion);

}

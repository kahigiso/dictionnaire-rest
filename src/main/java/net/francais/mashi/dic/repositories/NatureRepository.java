package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.Nature;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Nature,Long>{

	Nature findByName(String name);

}

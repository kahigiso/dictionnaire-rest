package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.Mot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotRepository extends JpaRepository<Mot, Integer>{

}

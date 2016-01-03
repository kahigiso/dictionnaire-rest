package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByEmail(String email);
}


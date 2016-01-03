package net.francais.mashi.dic.repositories;

import net.francais.mashi.dic.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);

}

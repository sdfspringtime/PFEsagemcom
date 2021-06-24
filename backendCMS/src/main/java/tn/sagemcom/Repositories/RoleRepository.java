package tn.sagemcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.sagemcom.Entities.Role;
import tn.sagemcom.Entities.User;

@Component
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}

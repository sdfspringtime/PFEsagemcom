package tn.sagemcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.sagemcom.Entities.Ressource;
import tn.sagemcom.Entities.Role;

@Component
@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long>{

}

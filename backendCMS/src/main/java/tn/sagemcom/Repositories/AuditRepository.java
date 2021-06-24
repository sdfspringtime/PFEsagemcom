package tn.sagemcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sagemcom.Entities.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long>{

}

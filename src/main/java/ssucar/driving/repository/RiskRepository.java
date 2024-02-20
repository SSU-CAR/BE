package ssucar.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssucar.driving.entity.Risk;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Integer> {

}
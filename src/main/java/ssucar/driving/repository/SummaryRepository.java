package ssucar.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssucar.driving.entity.Risk;
import ssucar.driving.entity.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

}
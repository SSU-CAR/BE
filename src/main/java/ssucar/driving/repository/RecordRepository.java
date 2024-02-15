package ssucar.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssucar.driving.entity.Report;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

}
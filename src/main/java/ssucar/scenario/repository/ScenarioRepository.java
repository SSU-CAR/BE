package ssucar.scenario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssucar.scenario.entity.Scenario;

import java.util.Optional;

public interface ScenarioRepository extends JpaRepository<Scenario, Integer> {
//    Optional<Scenario> findByScenarioName(Scenario.name name);
}

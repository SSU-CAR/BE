package ssucar.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssucar.driving.entity.Risk;
import ssucar.driving.entity.Summary;

import java.util.List;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {
    Summary findByReport_ReportIdAndScenarioType(int reportId, int scenarioType);
    List<Summary> findByReport_ReportId(int reportId);
}
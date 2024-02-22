package ssucar.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssucar.driving.entity.Report;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findTop3ByOrderByReportIdAsc();
    List<Report> findTop3ByOrderByReportIdDesc();

    List<Report> findByOrderByReportIdDesc();
}

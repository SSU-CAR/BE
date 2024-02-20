package ssucar.badge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssucar.badge.entity.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {
}

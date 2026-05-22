package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.htv.ams_backend.entity.DayPeriod;

@Repository
public interface DayPeriodRepository extends JpaRepository<DayPeriod, Integer> {
}
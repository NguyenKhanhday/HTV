package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.PriceDetail;

public interface PriceDetailRepository extends JpaRepository<PriceDetail, Integer> {
}
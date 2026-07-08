package vn.htv.ams_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
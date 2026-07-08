package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.PaymentTerm;

public interface PaymentTermRepository extends JpaRepository<PaymentTerm, Integer> {
}
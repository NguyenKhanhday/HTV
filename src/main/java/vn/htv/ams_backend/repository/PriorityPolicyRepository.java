package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.PriorityPolicy;

public interface PriorityPolicyRepository extends JpaRepository<PriorityPolicy, Integer> {
}
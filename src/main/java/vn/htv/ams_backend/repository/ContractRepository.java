package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
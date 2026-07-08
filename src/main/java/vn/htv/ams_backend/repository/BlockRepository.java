package vn.htv.ams_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.Block;

public interface BlockRepository extends JpaRepository<Block, Integer> {}
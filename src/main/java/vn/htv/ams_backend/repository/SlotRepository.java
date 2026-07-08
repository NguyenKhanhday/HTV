package vn.htv.ams_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Integer> {}
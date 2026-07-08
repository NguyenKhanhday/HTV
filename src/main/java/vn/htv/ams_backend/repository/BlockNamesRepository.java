package vn.htv.ams_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.htv.ams_backend.entity.BlockNames;
import java.util.List;

public interface BlockNamesRepository extends JpaRepository<BlockNames, Integer> {
    List<BlockNames> findByBlockId(Integer blockId);
}
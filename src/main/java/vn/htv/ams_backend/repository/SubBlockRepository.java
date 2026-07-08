package vn.htv.ams_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.htv.ams_backend.entity.SubBlock;
import vn.htv.ams_backend.dto.SubBlockMatrixDTO; // Import cái DTO vừa tạo

import java.util.List;

@Repository
public interface SubBlockRepository extends JpaRepository<SubBlock, Integer> {

    List<SubBlock> findByBlockId(Integer blockId);

    // Gọi Stored Procedure của sếp
    @Query(value = "EXEC Book_getSubblock_Load :channelId, :toDate", nativeQuery = true)
    List<SubBlockMatrixDTO> getSubblocksForMatrix(
            @Param("channelId") Integer channelId,
            @Param("toDate") String toDate
    );
}
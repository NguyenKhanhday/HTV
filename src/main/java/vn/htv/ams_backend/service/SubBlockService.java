package vn.htv.ams_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htv.ams_backend.dto.SubBlockMatrixDTO;
import vn.htv.ams_backend.entity.SubBlock;
import vn.htv.ams_backend.repository.SubBlockRepository;

import java.util.List;

@Service
public class SubBlockService {

    @Autowired
    private SubBlockRepository subBlockRepository;

    // 1. API dùng cho màn hình Ma Trận (Lấy tất cả)
    public List<SubBlock> getAllSubBlocks() {
        return subBlockRepository.findAll();
    }

    // 2. API dùng cho Tab 4 (Lấy theo từng Lịch Block)
    public List<SubBlock> getSubBlocksByBlockId(Integer blockId) {
        return subBlockRepository.findByBlockId(blockId);
    }

    // 3. API Lưu Khung QC
    public SubBlock saveSubBlock(SubBlock subBlock) {
        return subBlockRepository.save(subBlock);
    }

    // 4. API Xóa Khung QC
    public void deleteSubBlock(Integer id) {
        subBlockRepository.deleteById(id);
    }
    // Thêm hàm này vào Service
    public List<SubBlockMatrixDTO> getSubblocksForMatrix(Integer channelId, String toDate) {
        return subBlockRepository.getSubblocksForMatrix(channelId, toDate);
    }
}
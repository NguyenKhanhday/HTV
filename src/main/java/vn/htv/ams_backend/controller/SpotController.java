package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.Spot;
import vn.htv.ams_backend.service.SpotService;

import java.util.List;

@RestController
@RequestMapping("/api/spots")
@CrossOrigin("*")
public class SpotController {

    @Autowired
    private SpotService spotService;

    // API lấy dữ liệu để tô màu lên Ma trận (Load Data)
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Spot>> getSpotsByBook(@PathVariable("bookId") Integer bookId) {
        return ResponseEntity.ok(spotService.getSpotsByBookId(bookId));
    }

    // === ĐÃ SỬA LẠI ĐƯỜNG DẪN VÀ CÁCH NHẬN BIẾN ĐỂ KHỚP VỚI REACT ===
    @PostMapping("/matrix-save")
    public ResponseEntity<List<Spot>> saveMatrix(
            @RequestParam("bookId") Integer bookId, // Bắt tham số ?bookId=...
            @RequestBody List<Spot> spots) {

        List<Spot> savedSpots = spotService.saveMatrix(bookId, spots);
        return ResponseEntity.ok(savedSpots);
    }
}
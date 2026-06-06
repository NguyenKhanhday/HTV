package vn.htv.ams_backend.controller;

import vn.htv.ams_backend.entity.Contents;
import vn.htv.ams_backend.repository.ContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contents")
@CrossOrigin(origins = "*")
public class ContentsController {

    @Autowired
    private ContentsRepository contentsRepository;

    @GetMapping
    public ResponseEntity<List<Contents>> getAll() {
        return ResponseEntity.ok(contentsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contents> getById(@PathVariable Integer id) {
        return contentsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Contents contents) {
        if (contents.getCode() != null && contentsRepository.existsByCode(contents.getCode())) {
            return ResponseEntity.badRequest()
                    .body("Mã chương trình '" + contents.getCode() + "' đã tồn tại.");
        }
        return ResponseEntity.ok(contentsRepository.save(contents));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Contents payload) {
        Optional<Contents> optional = contentsRepository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Contents existing = optional.get();

        if (payload.getCode() != null
                && !payload.getCode().equals(existing.getCode())
                && contentsRepository.existsByCode(payload.getCode())) {
            return ResponseEntity.badRequest()
                    .body("Mã chương trình '" + payload.getCode() + "' đã tồn tại.");
        }

        existing.setCode(payload.getCode());
        existing.setOriginalTitle(payload.getOriginalTitle());
        existing.setVietNamTitle(payload.getVietNamTitle());
        existing.setOriginalEpisode(payload.getOriginalEpisode());
        existing.setOriginalDuration(payload.getOriginalDuration());
        existing.setTargetID(payload.getTargetID());
        existing.setDescription(payload.getDescription());
        existing.setPrImages(payload.getPrImages());
        existing.setProst(payload.getProst());
        existing.setPrBehindTheSing(payload.getPrBehindTheSing());
        existing.setPrOther(payload.getPrOther());
        existing.setScriptEnglish(payload.getScriptEnglish());
        existing.setScriptVietNam(payload.getScriptVietNam());
        existing.setScriptChina(payload.getScriptChina());
        existing.setScriptJapan(payload.getScriptJapan());
        existing.setScriptOther(payload.getScriptOther());
        existing.setUserUpdated(payload.getUserUpdated());

        return ResponseEntity.ok(contentsRepository.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!contentsRepository.existsById(id)) return ResponseEntity.notFound().build();
        contentsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contents>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(
                contentsRepository.findByOriginalTitleContainingIgnoreCaseOrVietNamTitleContainingIgnoreCase(
                        keyword, keyword));
    }
}
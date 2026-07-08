package vn.htv.ams_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.htv.ams_backend.entity.EpisodeNotAir;
import vn.htv.ams_backend.repository.EpisodeNotAirRepository;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/episode-not-airs")
@CrossOrigin("*")
public class EpisodeNotAirController {

    @Autowired
    private EpisodeNotAirRepository repository;

    @GetMapping
    public List<EpisodeNotAir> getAll() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public EpisodeNotAir save(@RequestBody EpisodeNotAir payload) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        if (payload.getEpisodeId() == null) {
            payload.setDateCreated(now);
            payload.setUserCreated("Admin");
        }
        payload.setDateUpdated(now);
        payload.setUserUpdated("Admin");
        return repository.save(payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
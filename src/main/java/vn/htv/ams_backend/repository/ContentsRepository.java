package vn.htv.ams_backend.repository;

import vn.htv.ams_backend.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Integer> {

    boolean existsByCode(String code);

    Optional<Contents> findByCode(String code);

    List<Contents> findByOriginalTitleContainingIgnoreCaseOrVietNamTitleContainingIgnoreCase(
            String originalTitle, String vietNamTitle);
}
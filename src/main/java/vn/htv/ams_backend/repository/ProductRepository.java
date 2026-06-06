package vn.htv.ams_backend.repository;

import vn.htv.ams_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Tìm theo mã sản phẩm (Code là unique)
    Optional<Product> findByCode(String code);

    // Kiểm tra mã sản phẩm đã tồn tại chưa (dùng khi validate)
    boolean existsByCode(String code);

    // Lọc theo trạng thái
    List<Product> findByStatus(Integer status);

    // Lọc theo nhóm sản phẩm
    List<Product> findByCatID(Integer catID);

    // Tìm kiếm tên sản phẩm (không phân biệt hoa thường)
    List<Product> findByNameContainingIgnoreCase(String name);
}
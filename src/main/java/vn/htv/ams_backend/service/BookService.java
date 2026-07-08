package vn.htv.ams_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htv.ams_backend.entity.Book;
import vn.htv.ams_backend.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        // Có thể thêm logic kiểm tra ràng buộc StartDate/EndDate ở đây trước khi lưu
        return bookRepository.save(book);
    }

    public Book update(Integer id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Lịch Book với ID: " + id));

        book.setSectionId(bookDetails.getSectionId());
        book.setChannelId(bookDetails.getChannelId());
        book.setTapeId(bookDetails.getTapeId());
        book.setCode(bookDetails.getCode());
        book.setCustomerCode(bookDetails.getCustomerCode());
        book.setBookDate(bookDetails.getBookDate());
        book.setStartDate(bookDetails.getStartDate());
        book.setEndDate(bookDetails.getEndDate());
        book.setStatus(bookDetails.getStatus());
        book.setDescription(bookDetails.getDescription());
        book.setUserUpdate(bookDetails.getUserUpdate());

        return bookRepository.save(book);
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
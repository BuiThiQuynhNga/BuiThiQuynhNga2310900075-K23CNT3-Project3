package k23cnt3.btqn.day06.service;

import k23cnt3.btqn.day06.entity.btqnBook;
import k23cnt3.btqn.day06.repository.BtqnAuthorRepository;
import k23cnt3.btqn.day06.repository.BtqnBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtqnBookService {
    @Autowired
    private BtqnBookRepository btqnBookRepository;
    //lay toan bo danh sach book
    public List<btqnBook> getAllBtqnBooks(){
        return btqnBookRepository.findAll();
    }
    public btqnBook getBtqnBookById(Long btqnId){
        return btqnBookRepository.findById(btqnId).orElse(null);
    }
    //cap nhat thong tin sach
    public btqnBook saveBtqnBook(btqnBook btqnBook){
        return btqnBookRepository.save(btqnBook);
    }
    public void deleteBtqnBookById(Long btqnBookId){
        btqnBookRepository.deleteById(btqnBookId);
    }
}

package k23cnt3.btqn.day06.service;

import k23cnt3.btqn.day06.entity.btqnAuthor;
import k23cnt3.btqn.day06.repository.BtqnAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtqnAuthorService {
    @Autowired
    private BtqnAuthorRepository btqnAuthorRepository;
    public List<btqnAuthor>getAllBtqnBookId(){
        return btqnAuthorRepository.findAll();
    }
    //lay ra mot tac gia
    public  btqnAuthor getBtqnAuthorById(Long btqnId){
        return  btqnAuthorRepository.findById(btqnId).orElse(null);
    }
    //cap nhat thong tin
    public btqnAuthor saveBtqnAuthor(btqnAuthor btqnAuthor){
        return btqnAuthorRepository.save(btqnAuthor);
    }
    public  void deleteBtqnAuthorById(Long btqnId){
        btqnAuthorRepository.deleteById(btqnId);
    }
}


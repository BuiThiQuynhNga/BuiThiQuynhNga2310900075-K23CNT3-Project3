package k23cnt3.btqn.day06.controller;

import k23cnt3.btqn.day06.repository.BtqnBookRepository;
import k23cnt3.btqn.day06.service.BtqnAuthorService;
import k23cnt3.btqn.day06.service.BtqnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/btqnbooks")
public class BtqnBookController {
    @Autowired
    private BtqnBookService btqnBookService;
    @Autowired
    private BtqnAuthorService btqnAuthorService;
    //get all
}

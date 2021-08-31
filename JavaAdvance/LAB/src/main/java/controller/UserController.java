package controller;

import entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.hibernate.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class UserController {
    public ResponseEntity< List<Account>> getAll(){
        return  new ResponseEntity<List<Account>>( new AccountRepository().getAll(), HttpStatus.OK);
    }
}

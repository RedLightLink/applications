package com.Library.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
public class BooksController {
    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/biblioteca/add")
    public @ResponseBody String addNewBook( @RequestParam String name, @RequestParam String author, @RequestParam int date){
        Books b = new Books();
        b.setName(name);
        b.setAuthor(author);
        b.setDatePublished(date);
        booksRepository.save(b);
        return "Saved";
    }

    @GetMapping("/biblioteca/all")
    public @ResponseBody ResponseEntity<Iterable<Books>> getAllBooks(){
        return new ResponseEntity<>(booksRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/biblioteca")
    public ResponseEntity<String> HomePage(){
        return new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @GetMapping("/biblioteca/{id}")
    public ResponseEntity<Optional<Books>> getBook(@PathVariable(name="id")Integer id) {
        if(booksRepository.existsById(id)){
            return new ResponseEntity<>(booksRepository.findById(id),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/biblioteca/del/{id}")
    public @ResponseBody ResponseEntity<Iterable<Integer>> dellByID(@PathVariable Integer id){
        booksRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

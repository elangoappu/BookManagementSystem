package com.example.BookManagementSystem.Controller;

import com.example.BookManagementSystem.Model.Book;
import com.example.BookManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class BookController {

    @Autowired
    private BookService service;


    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){

        return "bookRegister";
    }

    @GetMapping("/available_books")
    //public ModelAndView getAllBook() {
    public ModelAndView getAllBook() {
        List<Book> list=service.getAllBook();
        ModelAndView m=new ModelAndView();
        m.setViewName("bookList");
        //m.addObject("book",list);
        // return m;
        return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b=service.getBookById(id);

        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_books";
}

}

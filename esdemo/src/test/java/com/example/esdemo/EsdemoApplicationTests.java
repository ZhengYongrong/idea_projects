package com.example.esdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EsdemoApplicationTests {


    @Autowired
    BookRepository bookRepository;

    @Test
    public void test01(){
        Book book = new Book();
        book.setId(3);
        book.setBookName("西游记");
        book.setAuthor("吴承恩12");
        bookRepository.index(book);
    }
    @Test
    public void test02(){

		for (Book book : bookRepository.findByBookNameLike("游")) {
			System.out.println(book);
		}
    }
    @Test
    public void test03(){

        for (Book book : bookRepository.findBookByAuthorAndBookNameLike("吴","游")) {
            System.out.println(book);
        }
    }
}
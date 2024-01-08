package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service //BookService 인터페이스 구현체
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBookList();
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> bookByCategory = bookRepository.getBookListByCategory(category);
		return bookByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}

	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}

	@Override
	public void setNewBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.setNewBook(book);
	}

}

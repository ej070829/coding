package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
@RequestMapping("/books")//get
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView mav = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		mav.addObject("bookList", list);
		mav.setViewName("books");
		return mav;
	}
	
	@GetMapping("/{category}")
	public String requstBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	public String requestBookByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		return "books";
	}
	
	@GetMapping("/book")
	public ModelAndView requestbookById(@RequestParam("id") String bookId) {
		ModelAndView mav = new ModelAndView();
		Book bookById = bookService.getBookById(bookId);
		mav.addObject(bookById);
		mav.setViewName("book");
		return mav;
	}
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		return "addBook";
	}
	
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book) {
		MultipartFile bookImage = book.getBookImage();
		String localImageName = bookImage.getOriginalFilename();
		String localImagePath ="C:\\Users\\jihoo\\springImage";
		File saveFile = new File(localImagePath,localImageName);

        // Eclipse ������Ʈ ���� �̹����� ������ ���丮 ���
        String projectDirectory = System.getProperty("user.dir");
//        String imagesDirectory = projectDirectory + "C:\\Users\\jihoo\\eclipse-workspace\\BookMarket\\src\\main\\webapp\\resources\\image\\"; // ���� ���
        String imagesDirectory = "C:\\Users\\jihoo\\eclipse-workspace\\BookMarket\\src\\main\\webapp\\resources\\image\\"; // ���� ���
        System.out.println("user.dir"+projectDirectory);
        projectDirectory = System.getProperty("java.class.path");
        System.out.println("java.class.path"+projectDirectory);
        projectDirectory = System.getProperty("user.home");
        System.out.println("user.home"+projectDirectory);

        
        // �̹����� �ҷ��� Eclipse ������Ʈ ���� ���丮�� ����
        try {
            Path targetDirectory = Path.of(imagesDirectory);
            System.out.println(targetDirectory);
            System.out.println(Files.exists(targetDirectory));

            // ���丮�� ���ٸ� ����
            if (!Files.exists(targetDirectory)) {
                Files.createDirectories(targetDirectory);
            }

            // Ÿ�� ���丮 ���� �̹��� ���� ����
            Path targetPath = targetDirectory.resolve(saveFile.getName());
            Files.copy(saveFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(saveFile.toPath()+"\n"+targetPath);
            System.out.println("�̹��� ������ ���������� ������Ʈ ���� ���丮�� ����Ǿ����ϴ�.");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("�̹��� ������ �����ϴ� �� ������ �߻��߽��ϴ�.");
        }
		finally {
			bookService.setNewBook(book);	
			System.out.println("finally");
		}
        return "redirect:/books";
	}
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "�ű� ���� ���");
	}
// ModelAndView �ᵵ �� addAttributes()���
//	@PostMapping("/add")
//	public ModelAndView submitAddNewBook(@ModelAttribute("NewBook") Book book) {
//		MultipartFile bookImage = book.getBookImage();
//		String saveName = bookImage.getOriginalFilename();
//		File saveFile = new File("C:\\Users\\jihoo\\springImage",saveName);
//		
//		if(bookImage != null && !bookImage.isEmpty()) {
//			try {
//				bookImage.transferTo(saveFile);
//			} catch(Exception e) {
//				throw new RuntimeException("���� �̹��� ���ε尡 �����Ͽ����ϴ�.",e);
//			}
//		}
//		
//		bookService.setNewBook(book);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("addTitle", "�ű� ���� ���");
//		mav.setViewName("redirect:/books");
//		return mav;
//	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId","name","unitPrice","author","description","publisher","category","unitsInStock","releaseDate","condition", "bookImage");
	}
}

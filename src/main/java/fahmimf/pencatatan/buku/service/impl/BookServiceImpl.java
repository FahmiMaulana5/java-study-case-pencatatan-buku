package fahmimf.pencatatan.buku.service.impl;

import fahmimf.pencatatan.buku.entity.Book;
import fahmimf.pencatatan.buku.repository.BookRepository;
import fahmimf.pencatatan.buku.service.BookService;

public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(String title, String author, Integer year) {
       
        // Initialize
        Book book = new Book(title, author, year);

        // Add Book
        bookRepository.add(book);

        // Return
        System.out.println("Book Added Successfully : " + book.getTitle());

    }

    @Override
    public void getAll() {
       // Initialize
       Book[] list = bookRepository.getAll();

       // Return
       for (Book book : list) {
           System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
       }
    }

    @Override
    public void getById(Integer id) {
        // Get Data
        Book book = bookRepository.getById(id);

        // Return
        System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
    }

    @Override
    public void update(Integer id, String title, String author, Integer year) {
         // Initialize
         Book book = new Book(title, author, year);

         // Update Book
         bookRepository.update(id, title, author, year);
 
         // Return
         System.out.println("Book Updated Successfully : " + book.getTitle());
    }

    @Override
    public void delete(Integer id) {
        // Delete Data
        boolean success = bookRepository.delete(id); // true or false

        if (success == true) {
            // Return
            System.out.println("Book Deleted Successfully : " + id);
        } else {
            // Return
            System.out.println("Failed to Deleted Book : " + id);
        }
    }
    
}

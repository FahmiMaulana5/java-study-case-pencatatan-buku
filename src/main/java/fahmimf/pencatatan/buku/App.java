package fahmimf.pencatatan.buku;

import javax.sql.DataSource;

import fahmimf.pencatatan.buku.repository.BookRepository;
import fahmimf.pencatatan.buku.repository.impl.BookRepositoryImpl;
import fahmimf.pencatatan.buku.service.BookService;
import fahmimf.pencatatan.buku.service.impl.BookServiceImpl;
import fahmimf.pencatatan.buku.util.DatabaseUtil;
import fahmimf.pencatatan.buku.view.BookView;


public class App {
    public static void main(String[] args) {
        // Datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set Datasource
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        // Show Menu
        bookView.showMenu();
    }
}
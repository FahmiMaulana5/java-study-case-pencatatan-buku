package fahmimf.pencatatan.buku;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import fahmimf.pencatatan.buku.repository.BookRepository;
import fahmimf.pencatatan.buku.repository.impl.BookRepositoryImpl;
import fahmimf.pencatatan.buku.service.BookService;
import fahmimf.pencatatan.buku.service.impl.BookServiceImpl;
import fahmimf.pencatatan.buku.util.DatabaseUtil;
import fahmimf.pencatatan.buku.view.BookView;

public class AppTest {

    @Test
    public void testApp() {
        // Datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set Datasource
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        assertNotNull(bookView);
    }

}
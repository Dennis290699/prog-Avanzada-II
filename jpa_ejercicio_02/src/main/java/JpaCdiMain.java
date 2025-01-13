import com.programacion.avanzada2.db.Book;
import com.programacion.avanzada2.repository.AuthorRepository;
import com.programacion.avanzada2.repository.BookRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.math.BigDecimal;
import java.util.List;

public class JpaCdiMain {
    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();

        var repoBooks = container.select(BookRepository.class).get();

        var book = repoBooks.findBy(1);
        System.out.println(book);

        //--
        var repoAuthors = container.select(AuthorRepository.class).get();

        repoAuthors.findAll().forEach(System.out::println);

        var book1 = repoBooks.findByIsbn("1111");
        System.out.println(book1);

        List<Book> librosMayor10 = repoBooks.findByPrecioGreaterThan(BigDecimal.TEN);
        librosMayor10.stream().forEach(System.out::println);
    }
}

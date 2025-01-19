import com.programacion.avanzada2.db.Author;
import com.programacion.avanzada2.db.Book;
import com.programacion.avanzada2.repository.AuthorRepository;
import com.programacion.avanzada2.repository.BookRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class JpaCdiMain {
    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();

//        var repoBooks = container.select(BookRepository.class).get();
//
//        var book = repoBooks.findBy(1);
//        System.out.println(book);
//
//        //--
//        var repoAuthors = container.select(AuthorRepository.class).get();
//
//        repoAuthors.findAll().forEach(System.out::println);
//
//        var book1 = repoBooks.findByIsbn("1111");
//        System.out.println(book1);
//
//        List<Book> librosMayor10 = repoBooks.findByPrecioGreaterThan(BigDecimal.TEN);
//        librosMayor10.stream().forEach(System.out::println);


//        //-- USO DE REPOSITORY
//        var repoAuthors = container.select(AuthorRepository.class).get();
//        Author a1 = new Author();
//        a1.setId(3);
//        a1.setApellido("apellido X");
//        a1.setNombre("nombre X");
//        repoAuthors.save(a1);
//
//        a1 = repoAuthors.findBy(3);
//        a1.setApellido("rrrrrrr");
//        repoAuthors.save(a1);

//        //--ENTITYMANAGER
        EntityManager em = container.select(EntityManager.class).get();
//        em.getTransaction().begin();
//        em.persist(a1);
//        em.getTransaction().commit();
//
//        em.getTransaction().begin();
//        a1= em.find(Author.class, 3);
//        a1.setApellido("apellido Y");
//        em.getTransaction().commit();
    }
}

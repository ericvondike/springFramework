package commence.springframework.spring5webapp.bootstrap;

import commence.springframework.spring5webapp.model.Author;
import commence.springframework.spring5webapp.model.Book;
import commence.springframework.spring5webapp.model.Publisher;
import commence.springframework.spring5webapp.repositories.AuthorRepository;
import commence.springframework.spring5webapp.repositories.BookRepository;
import commence.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher("Harper Collins", "2 Colling Street USA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher publisher_1 = new Publisher("Worx", "25 Worx Street, United States");
        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Delevopment Without EJB", "23444", publisher_1);
        rod.getBooks().add(noEJB);

        publisherRepository.save(publisher_1);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}

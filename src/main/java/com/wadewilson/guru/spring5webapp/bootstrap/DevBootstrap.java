package com.wadewilson.guru.spring5webapp.bootstrap;

import com.wadewilson.guru.spring5webapp.model.Author;
import com.wadewilson.guru.spring5webapp.model.Book;
import com.wadewilson.guru.spring5webapp.model.Publisher;
import com.wadewilson.guru.spring5webapp.repositories.AuthorRepository;
import com.wadewilson.guru.spring5webapp.repositories.BookRepository;
import com.wadewilson.guru.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

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

    private void initData() {
        Author eric = new Author("Eric", " Evans");
        Publisher publisher1 = new Publisher();
        publisher1.setName("Publisher1");
        publisher1.setAddress("Address1");
        publisherRepository.save(publisher1);

        Book didi = new Book("J2EE Developement without EJB", "2344", publisher1);

        eric.getBooks().add(didi);
        didi.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(didi);

        Author rod = new Author("Rod", "johnson");
        Publisher publisher2 = new Publisher();
        publisher2.setName("publisher2");
        publisher2.setAddress("Address2");
        publisherRepository.save(publisher2);
        Book noEJB = new Book("Domain Driven Design", "1234", publisher2);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}

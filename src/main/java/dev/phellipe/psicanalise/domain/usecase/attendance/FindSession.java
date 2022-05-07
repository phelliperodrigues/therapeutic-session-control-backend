package dev.phellipe.psicanalise.domain.usecase.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record FindSession(SessionRepositoryFacade repositoryFacade) {

    public Page<Session> execute(Session filter, Pageable pageable){
        var filters = Example.of(filter,
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withIgnoreNullValues()
                        .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING)
        ) ;
        return repositoryFacade.findAll(filters, pageable);
    }
}

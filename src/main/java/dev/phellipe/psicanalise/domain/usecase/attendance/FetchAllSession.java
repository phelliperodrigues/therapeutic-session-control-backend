package dev.phellipe.psicanalise.domain.usecase.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public record FetchAllSession(
        SessionRepositoryFacade repositoryFacade) {

    public Page<Session> execute(Pageable pageable){
        log.info("Buscando todos as sessões");
        return repositoryFacade.findAll(pageable);
    }
}

package dev.phellipe.psicanalise.domain.usecase.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record CreateSession(SessionRepositoryFacade repositoryFacade) {

    public Session execute(Session session) {
        var created = repositoryFacade.save(session);
        log.info("Novo sessão criada, ID: {}", session.getId());
        return created;
    }

}

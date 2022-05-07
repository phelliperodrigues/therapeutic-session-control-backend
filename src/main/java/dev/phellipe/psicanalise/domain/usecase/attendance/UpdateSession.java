package dev.phellipe.psicanalise.domain.usecase.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Component
public record UpdateSession(SessionRepositoryFacade repositoryFacade) {

    public Session execute(UUID id, Session session) {
        return repositoryFacade.findById(id).map(fetch -> {
            log.info("Atualizando sessão com id {}", id);
            fetch.update(session);
            return repositoryFacade.save(fetch);
        }).orElseGet(() -> {
            var msg = "Erro ao Atualizar! Sessão não encontrada com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}

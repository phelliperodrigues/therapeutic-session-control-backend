package dev.phellipe.psicanalise.domain.usecase.attendance;

import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Component
public record DeleteSession(SessionRepositoryFacade repositoryFacade) {

    public void execute(UUID id){
        repositoryFacade.findById(id).ifPresentOrElse(session -> {
            repositoryFacade.delete(session);
            log.info("Sessão deletada com sucesso! id {}", id);

        }, () -> {
            var msg = "Erro ao Deletar! Sessão não encontrada com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}

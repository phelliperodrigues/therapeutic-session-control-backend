package dev.phellipe.psicanalise.domain.repository.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepositoryFacade {
    Session save(Session session);

    Optional<Session> findById(UUID id);

    Page<Session> findAll(Pageable pageable);

    void delete(Session session);

    Page<Session> findAll(Example<Session> filters, Pageable pageable);
}

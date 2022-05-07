package dev.phellipe.psicanalise.infrastructure.database.pg.facades.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.repository.attendance.SessionRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionRepositoryFacadeImpl implements SessionRepositoryFacade {
    @Override
    public Session save(Session session) {
        return null;
    }

    @Override
    public Optional<Session> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<Session> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Page<Session> findAll(Example<Session> filters, Pageable pageable) {
        return null;
    }
}

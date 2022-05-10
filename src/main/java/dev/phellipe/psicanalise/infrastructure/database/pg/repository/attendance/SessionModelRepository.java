package dev.phellipe.psicanalise.infrastructure.database.pg.repository.attendance;

import dev.phellipe.psicanalise.infrastructure.database.pg.model.attendance.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionModelRepository extends JpaRepository<SessionModel, UUID> {
}
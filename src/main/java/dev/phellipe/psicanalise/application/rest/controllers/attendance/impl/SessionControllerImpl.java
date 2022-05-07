package dev.phellipe.psicanalise.application.rest.controllers.attendance.impl;

import dev.phellipe.psicanalise.application.rest.controllers.attendance.SessionController;
import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionRequest;
import dev.phellipe.psicanalise.application.rest.responses.attendance.SessionResponse;
import dev.phellipe.psicanalise.domain.usecase.attendance.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.SESSION_API;
import static dev.phellipe.psicanalise.application.rest.mappers.attendance.SessionMapper.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = SESSION_API)
public class SessionControllerImpl implements SessionController {

    private final CreateSession createSession;
    private final DeleteSession deleteSession;
    private final FetchSessionById fetchSessionById;
    private final FindSession findSession;
    private final UpdateSession updateSession;

    @Override
    public ResponseEntity<SessionResponse> create(SessionRequest request) {
        var session = createSession.execute(convertToEntity(request));
        return ResponseEntity.created(URI.create("")).body(convertToResponse(session));
    }

    @Override
    public ResponseEntity<SessionResponse> findById(UUID id) {
        var session = fetchSessionById.execute(id);
        return ResponseEntity.ok(convertToResponse(session));
    }

    @Override
    public ResponseEntity<Page<SessionResponse>> findAll(SessionFilterRequest request, Pageable pageable) {
        var sessions = findSession.execute(convertToEntity(request), pageable);
        var response = convertToResponsePageable(sessions);
        return ResponseEntity.ok(new PageImpl<>(response, pageable, sessions.getTotalElements()));
    }

    @Override
    public ResponseEntity<SessionResponse> update(UUID id, SessionRequest request) {
        var session = updateSession.execute(id, convertToEntity(request));
        return ResponseEntity.ok(convertToResponse(session));
    }

    @Override
    public void deleteById(UUID id) {
        deleteSession.execute(id);
    }
}

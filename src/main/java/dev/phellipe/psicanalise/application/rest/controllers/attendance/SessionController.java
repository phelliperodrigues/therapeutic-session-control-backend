package dev.phellipe.psicanalise.application.rest.controllers.attendance;

import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionRequest;
import dev.phellipe.psicanalise.application.rest.responses.attendance.SessionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.SESSION_API;
import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.SESSION_API_BY_ID;

@RequestMapping(path = SESSION_API)
@Tag(name = "Sessions API")
public interface SessionController {

    @Operation(summary = "Create a session", description = "", method = "create(SessionRequest request)")
    @PostMapping
    @Tag(name = "Sessions API")
    ResponseEntity<SessionResponse> create(@RequestBody SessionRequest request);

    @Operation(summary = "Fetch a session by id", description = "", method = "findById(UUID id)")
    @GetMapping(path = SESSION_API_BY_ID)
    @Tag(name = "Sessions API")
    ResponseEntity<SessionResponse> findById(@PathVariable("id") UUID id);

    @Operation(summary = "Fetch and filter all session pageable", description = "", method = "findAll(SessionFilterRequest request)")
    @GetMapping
    @Tag(name = "Sessions API")
    ResponseEntity<Page<SessionResponse>> findAll(SessionFilterRequest request, Pageable pageable);

    @Operation(summary = "Update a session by id", description = "", method = "update(UUID id, SessionRequest request)")
    @PutMapping(path = SESSION_API_BY_ID)
    @Tag(name = "Sessions API")
    ResponseEntity<SessionResponse> update(@PathVariable("id") UUID id, @RequestBody SessionRequest request);

    @Operation(summary = "Drop a session by id", description = "", method = "deleteById(UUID id)")
    @DeleteMapping(path = SESSION_API_BY_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name = "Sessions API")
    void deleteById(@PathVariable("id") UUID id);
}

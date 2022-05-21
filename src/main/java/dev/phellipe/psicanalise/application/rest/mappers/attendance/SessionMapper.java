package dev.phellipe.psicanalise.application.rest.mappers.attendance;

import dev.phellipe.psicanalise.application.rest.mappers.customer.CustomerMapper;
import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.attendance.SessionRequest;
import dev.phellipe.psicanalise.application.rest.responses.attendance.SessionResponse;
import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class SessionMapper {
    public static Session convertToEntity(SessionRequest request) {
        return Session.builder()
                .id(request.getId())
                .customer(CustomerMapper.convertToEntity(request.getCustomer()))
                .schedule(request.getSchedule())
                .value(request.getValue())
                .observation(request.getObservation())
                .build();
    }

    public static Session convertToEntity(SessionFilterRequest request) {
        return Session.builder()
                .id(request.getId())
                .customer(CustomerMapper.convertToEntity(request.getCustomer()))
                .schedule(request.getSchedule())
                .value(request.getValue())
                .observation(request.getObservation())
                .build();
    }

    public static SessionResponse convertToResponse(Session session) {
        return SessionResponse.builder()
                .id(session.getId())
                .customer(CustomerMapper.convertToResponse(session.getCustomer()))
                .schedule(session.getSchedule())
                .value(session.getValue())
                .annotation(session.getObservation())
                .build();
    }

    public static List<SessionResponse> convertToResponsePageable(Page<Session> sessions) {
        return sessions.stream()
                .map(SessionMapper::convertToResponse)
                .collect(Collectors.toList());
    }
}

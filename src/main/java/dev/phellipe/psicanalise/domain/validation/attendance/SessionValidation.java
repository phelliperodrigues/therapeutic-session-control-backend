package dev.phellipe.psicanalise.domain.validation.attendance;

import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.validation.EntityValidation;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor(staticName = "build")
public class SessionValidation extends EntityValidation<Session> {
    @Override
    public void validate(Session session) {
        var errors = new ArrayList<String>();
        if (session.getCustomer() != null) errors.add("Cliente é obrigatório");
        if (session.getValue() < 0) errors.add("Valor está invalido");
        if (session.getSchedule() != null) errors.add("Data da sessão é obrigatório");
        exception(errors);
    }
}

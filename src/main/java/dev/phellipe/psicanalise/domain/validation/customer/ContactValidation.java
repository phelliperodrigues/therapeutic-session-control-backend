package dev.phellipe.psicanalise.domain.validation.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Contact;
import dev.phellipe.psicanalise.domain.validation.EntityValidation;
import dev.phellipe.psicanalise.utils.EmailUtils;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static dev.phellipe.psicanalise.utils.StringUtils.isNullOrEmpty;

@NoArgsConstructor(staticName = "build")
public class ContactValidation extends EntityValidation<Contact> {

    @Override
    public void validate(Contact contact) {
        var errors = new ArrayList<String>();
        if (isNullOrEmpty(contact.getEmail())) errors.add("Email é obrigatório");

        if (!EmailUtils.validate(contact.getEmail())) errors.add("Email não é Valido");

        if (isNullOrEmpty(contact.getPhone())) errors.add("Telefone é obrigatório");


        exception(errors);
    }
}

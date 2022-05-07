package dev.phellipe.psicanalise.application.rest.mappers.customer;

import dev.phellipe.psicanalise.application.rest.requests.customer.ContactRequest;
import dev.phellipe.psicanalise.application.rest.responses.customer.ContactResponse;
import dev.phellipe.psicanalise.domain.entity.customer.Contact;

public class ContactMapper {

    public static ContactResponse convertToResponse(Contact contact) {
        return ContactResponse.builder()
                .contactPhone(contact.getContactPhone())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }

    public static Contact convertToEntity(ContactRequest request) {
        return Contact.builder()
                .contactPhone(request.getContactPhone())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }
}

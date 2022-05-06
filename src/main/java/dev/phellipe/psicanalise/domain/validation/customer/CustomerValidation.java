package dev.phellipe.psicanalise.domain.validation.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.validation.EntityValidation;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static dev.phellipe.psicanalise.utils.StringUtils.isNullOrEmpty;

@NoArgsConstructor(staticName = "build")
public class CustomerValidation extends EntityValidation<Customer> {

    public void validate(Customer customer) {
        var errors = new ArrayList<String>();
        if (isNullOrEmpty(customer.getName())) errors.add("Nome é obrigatório");

        if (isNullOrEmpty(customer.getDocumentNumber())) errors.add("CPF é obrigatório");

        if (isNullOrEmpty(customer.getRg())) errors.add("RG é obrigatório");

        if (customer.getAddress() == null) errors.add("Endereço é obrigatório");

        if (customer.getContact() == null) errors.add("Contato é obrigatório");

        if (customer.getPaymentMethods().isEmpty()) errors.add("Tipos de Pagamento é obrigatório");

        exception(errors);

    }
}

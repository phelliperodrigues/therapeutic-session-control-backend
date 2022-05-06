package dev.phellipe.psicanalise.domain.validation.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Address;
import dev.phellipe.psicanalise.domain.validation.EntityValidation;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static dev.phellipe.psicanalise.utils.StringUtils.isNullOrEmpty;

@NoArgsConstructor(staticName = "build")
public class AddressValidation extends EntityValidation<Address> {

    @Override
    public void validate(Address address) {
        var errors = new ArrayList<String>();
        if (isNullOrEmpty(address.getCity())) errors.add("Cidade é obrigatório");

        if (isNullOrEmpty(address.getDistrict())) errors.add("Bairro é obrigatório");

        if (isNullOrEmpty(address.getNumber())) errors.add("Numero é obrigatório");

        if (isNullOrEmpty(address.getState())) errors.add("Estado é obrigatório");

        if (isNullOrEmpty(address.getStreet())) errors.add("Rua é obrigatório");

        if (isNullOrEmpty(address.getZipCode())) errors.add("CEP é obrigatório");

        exception(errors);
    }
}

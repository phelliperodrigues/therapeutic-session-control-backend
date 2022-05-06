package dev.phellipe.psicanalise.domain.validation.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import dev.phellipe.psicanalise.domain.validation.EntityValidation;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static dev.phellipe.psicanalise.utils.StringUtils.isNullOrEmpty;

@NoArgsConstructor(staticName = "build")
public class PaymentMethodValidation extends EntityValidation<PaymentMethod> {
    @Override
    public void validate(PaymentMethod paymentMethod) {
        var errors = new ArrayList<String>();
        if (isNullOrEmpty(paymentMethod.getDescription())) errors.add("Descrição é obrigatório");
        exception(errors);
    }
}

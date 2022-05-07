package dev.phellipe.psicanalise.application.rest.mappers.customer;

import dev.phellipe.psicanalise.application.rest.mappers.attendance.SessionMapper;
import dev.phellipe.psicanalise.application.rest.mappers.managerial.PaymentMethodMapper;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import dev.phellipe.psicanalise.application.rest.responses.attendance.SessionResponse;
import dev.phellipe.psicanalise.application.rest.responses.customer.CustomerResponse;
import dev.phellipe.psicanalise.domain.entity.attendance.Session;
import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerResponse convertToResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .address(AddressMapper.convertToResponse(customer.getAddress()))
                .contact(ContactMapper.convertToResponse(customer.getContact()))
                .documentNumber(customer.getDocumentNumber())
                .name(customer.getName())
                .rg(customer.getRg())
                .paymentMethods(customer.getPaymentMethods().stream().map(PaymentMethodMapper::convertToResponse).collect(Collectors.toSet()))
                .build();
    }

    public static Customer convertToEntity(CustomerRequest customer) {
        return Customer.builder()
                .id(customer.getId())
                .address(AddressMapper.convertToEntity(customer.getAddress()))
                .contact(ContactMapper.convertToEntity(customer.getContact()))
                .documentNumber(customer.getDocumentNumber())
                .name(customer.getName())
                .rg(customer.getRg())
                .paymentMethods(customer.getPaymentMethods().stream().map(PaymentMethodMapper::convertToEntity).collect(Collectors.toSet()))
                .build();
    }

    public static Customer convertToEntity(CustomerFilterRequest customer) {
        return Customer.builder()
                .id(customer.getId())
                .address(AddressMapper.convertToEntity(customer.getAddress()))
                .contact(ContactMapper.convertToEntity(customer.getContact()))
                .documentNumber(customer.getDocumentNumber())
                .name(customer.getName())
                .rg(customer.getRg())
                .paymentMethods(customer.getPaymentMethods().stream().map(PaymentMethodMapper::convertToEntity).collect(Collectors.toSet()))
                .build();
    }

    public static List<CustomerResponse> convertToResponsePageable(Page<Customer> customers) {
        return customers.stream()
                .map(CustomerMapper::convertToResponse)
                .collect(Collectors.toList());
    }
}

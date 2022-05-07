package dev.phellipe.psicanalise.application.rest.mappers.customer;

import dev.phellipe.psicanalise.application.rest.requests.customer.AddressRequest;
import dev.phellipe.psicanalise.application.rest.responses.customer.AddressResponse;
import dev.phellipe.psicanalise.domain.entity.customer.Address;

public class AddressMapper {

    public static AddressResponse convertToResponse(Address address) {
        return AddressResponse.builder()
                .city(address.getCity())
                .complement(address.getComplement())
                .district(address.getDistrict())
                .number(address.getNumber())
                .state(address.getState())
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .build();
    }

    public static Address convertToEntity(AddressRequest request) {
        return Address.builder()
                .city(request.getCity())
                .complement(request.getComplement())
                .district(request.getDistrict())
                .number(request.getNumber())
                .state(request.getState())
                .street(request.getStreet())
                .zipCode(request.getZipCode())
                .build();
    }
}

package dev.phellipe.psicanalise.application.rest.controllers;

public abstract class URLRequestMappers {
    private static final String V1_API = "/api/v1";
    public static final String CUSTOMER_API = V1_API + "/customers";
    public static final String CUSTOMER_API_BY_ID = "/{id}";

    public static final String SESSION_API = V1_API + "/sessions";
    public static final String SESSION_API_BY_ID = "/{id}";



    public static final String PAYMENT_METHOD_API = V1_API + "/payment-methods";
    public static final String PAYMENT_METHOD_API_BY_ID = "/{id}";
}

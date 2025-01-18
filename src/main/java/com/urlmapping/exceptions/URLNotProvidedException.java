package com.urlmapping.exceptions;

public class URLNotProvidedException extends ApplicationException {

    private static final String CODE = "003";
    private static final String DESCRIPTION = "URL não informada.";

    public URLNotProvidedException() {
        super(CODE, DESCRIPTION);
    }
}

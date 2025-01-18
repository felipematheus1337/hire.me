package com.urlmapping.exceptions;

public class AliasAlreadyExistsException extends ApplicationException {

    private static final String CODE = "001";
    private static final String DESCRIPTION = "CUSTOM ALIAS ALREADY EXISTS";

    public AliasAlreadyExistsException() {
        super(CODE, DESCRIPTION);
    }


}

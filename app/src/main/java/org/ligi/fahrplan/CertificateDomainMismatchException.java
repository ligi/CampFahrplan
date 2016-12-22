package org.ligi.fahrplan;

import java.security.cert.CertificateException;

public class CertificateDomainMismatchException extends CertificateException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CertificateDomainMismatchException(String message) {
        super(message);
    }
}

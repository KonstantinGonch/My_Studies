package com.none.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class URLValidator implements ConstraintValidator<URL, String> {
    private String host;
    private String protocol;
    private int port;

    public void initialize(URL url) {
        this.host = url.host();
        this.protocol = url.protocol();
        this.port = url.port();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.length()==0)
            return true;
        java.net.URL url;
        try
        {
            url = new java.net.URL(s);
        }
        catch (MalformedURLException ex)
        {
            return false;
        }
        if (protocol != null && protocol.length()>0 && !url.getProtocol().equals(protocol)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Wrong Protocol").addConstraintViolation();
            return false;
        }
        if (host!=null && host.length()>0 && !url.getHost().startsWith(host))
            return false;
        if (port != -1 && url.getPort()!=port)
            return false;
        return true;
    }
}

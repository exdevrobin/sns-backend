package org.hov.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hov.validator.ContactFormat;

@Documented
@Constraint(validatedBy = ContactFormat.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SNSContactFormat {
    String message() default " format is not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
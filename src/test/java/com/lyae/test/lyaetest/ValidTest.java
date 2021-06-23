package com.lyae.test.lyaetest;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import java.util.Set;

//valid 검증 방법
public class ValidTest {
    @Size(min = 1, max = 10)
    private String txt ;

    public static void main(String[] args) {

        ValidTest valid = new ValidTest();
        valid.txt = "1234567890일이삼";

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ValidTest>> violations = validator.validate(valid);
        System.out.println(violations.size()); //검증 오류가 있으면 0 이상
        violations.forEach( e-> {
            System.out.println(e.getPropertyPath() +" , "+ e.getInvalidValue() +" , "+ e.getMessage());
        });
    }
}

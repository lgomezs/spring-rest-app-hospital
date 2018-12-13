package pe.com.hospital.apphospital.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class HospitalBaseException extends RuntimeException{

	private Set<ConstraintViolation<?>> constrainValidation;

    public HospitalBaseException(Set constrainValidation) {
        this.constrainValidation = (Set<ConstraintViolation<?>>) constrainValidation;
    }

    public Set<ConstraintViolation<?>> getConstrainValidation() {
        return constrainValidation;
    }
    
}

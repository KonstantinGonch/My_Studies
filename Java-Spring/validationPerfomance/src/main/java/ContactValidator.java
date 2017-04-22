import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by JohnCena on 11.04.2017.
 */
public class ContactValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
    }
}

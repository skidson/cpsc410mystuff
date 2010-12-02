package ca.ubc.cpsc.mystuff.model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
@Component
public class RegisterValidator implements Validator {
public boolean supports(Class clazz) {
return User.class.isAssignableFrom(clazz);
}
public void validate(Object target, Errors errors) {
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
"required.courtName", "firstName is required.");
ValidationUtils.rejectIfEmpty(errors, "lastName",
"required.date", "lastName is required.");
ValidationUtils.rejectIfEmpty(errors, "username",
"required.hour", "user name is required.");
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
"required.playerName", "password is required.");
ValidationUtils.rejectIfEmpty(errors, "country",
"required.sportType", "country is required.");

}
}
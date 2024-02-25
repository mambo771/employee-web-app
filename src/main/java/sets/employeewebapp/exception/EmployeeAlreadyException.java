package sets.employeewebapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyException extends RuntimeException {
    public EmployeeAlreadyException() {
        super("Сотрудник уже существует");
    }
}

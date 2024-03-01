package sets.employeewebapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageFullException extends RuntimeException {
    public EmployeeStorageFullException() {
        super("Хранилище сотрудников заполнено");
    }
}

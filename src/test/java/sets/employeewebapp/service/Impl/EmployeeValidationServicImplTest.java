package sets.employeewebapp.service.Impl;

import org.junit.jupiter.api.Test;
import sets.employeewebapp.exception.InvalidEmployeeDataException;
import sets.employeewebapp.service.EmployeeValidationService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static sets.employeewebapp.EmployeeTestConstans.*;

class EmployeeValidationServicImplTest {
    private final EmployeeValidationService validationService = new EmployeeValidationServicImpl();
    @Test
    public void shouldThrowInvalidEmployeeDataException(){
        assertThrows(InvalidEmployeeDataException.class,
                () -> validationService.validate(No_corect_FirstName, No_corect_LastName));
    }
}
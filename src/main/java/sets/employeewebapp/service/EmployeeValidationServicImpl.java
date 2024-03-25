package sets.employeewebapp.service;

import org.springframework.stereotype.Service;
import sets.employeewebapp.exception.InvalidEmployeeDataExeption;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServicImpl implements  EmployeeValidationService{
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }
    private void validateName (String name){
        if(!isAlpha(name)){
            throw new InvalidEmployeeDataExeption("Некорректное имя сотрудника");
        }
    }
}

package demo.service;

import demo.repository.Employee;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Naveen Bensily on 6/20/15.
 */
@Component("employeeService")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {


  private EmployeeRepository employeeRepository;


   @Autowired
   public EmployeeServiceImpl(EmployeeRepository employeeRepository){
       this.employeeRepository=employeeRepository;
   }

  @Override
    public Employee getEmployeeById(int id) {
        //Assert.notNull(id, "Name must not be null");
        return this.employeeRepository.getEmployeeById(id);
    }

}

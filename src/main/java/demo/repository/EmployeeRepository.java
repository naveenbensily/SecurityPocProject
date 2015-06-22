package demo.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by Naveen Bensily on 6/20/15.
 */
@Repository
public interface EmployeeRepository extends org.springframework.data.repository.Repository<Employee, Long> {

    Employee getEmployeeById(int id);
}

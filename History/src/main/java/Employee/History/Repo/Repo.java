package Employee.History.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Employee.History.Entity.Employee;

public interface Repo  extends JpaRepository<Employee,Integer>{

}

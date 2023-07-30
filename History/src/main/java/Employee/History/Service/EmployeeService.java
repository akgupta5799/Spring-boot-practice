package Employee.History.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Employee.History.Entity.Employee;
import Employee.History.Repo.Repo;

@Service
public class EmployeeService {
@Autowired
public Repo repo;

  public List<Employee> getAllData(){
	  return repo.findAll();
  }
  
  public ResponseEntity<Employee> getById(int id) {
	  Optional<Employee> Employee = repo.findById(id);
	  if(Employee.isPresent()) {
		  return new ResponseEntity<>(Employee.get(),HttpStatus.OK);
	  }else {
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	  
  }
  
  public Employee postData(Employee emp) {
	  return repo.save(emp);
  }
  
  public ResponseEntity<Employee> updateData( Employee emp,  int id) {
	  Optional<Employee> Employee = repo.findById(id);
      if(Employee.isPresent()) {
    	  Employee.get().setName(emp.getName());
    	  Employee.get().setPosition(emp.getPosition());
    	  return new ResponseEntity<>(repo.save(Employee.get()),HttpStatus.OK);
      }
      else {
    	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
  public ResponseEntity<String> deleteData(Employee emp, int id){
	  Optional<Employee> Employee = repo.findById(id);
	  String msg = "Done";
	  String msg1 = "Data not found";
	  if(Employee.isPresent()) {
		  repo.deleteById(id);
		  return new ResponseEntity<>(msg,HttpStatus.OK);
	  }
	  else {
		  return new ResponseEntity<>(msg1,HttpStatus.NOT_FOUND);
	  }
  }
  



}

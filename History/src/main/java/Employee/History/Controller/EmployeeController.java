package Employee.History.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Employee.History.Entity.Employee;
import Employee.History.Service.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {
  @Autowired
  public EmployeeService service;
  
  @GetMapping("/getData")
  public List<Employee> gettingData(){
	  return service.getAllData();
  }
  
  @GetMapping("/getData/{id}")
  public ResponseEntity<Employee> gettingDataById(@PathVariable int id) {
	  return service.getById(id);
  }
  @PostMapping("/postData")
  public Employee postingData(@RequestBody Employee emp) {
	  return service.postData(emp);
  }
  
  @PutMapping("/updateData/{id}")
  public ResponseEntity<Employee> updattingData(@RequestBody Employee emp, @PathVariable int id){
	  return service.updateData(emp, id);
  }
  
  @DeleteMapping("/deleteData/{id}")
  public ResponseEntity<String> deletingData(@PathVariable int id, @RequestBody Employee emp){
	  return service.deleteData(emp, id);
  }
}

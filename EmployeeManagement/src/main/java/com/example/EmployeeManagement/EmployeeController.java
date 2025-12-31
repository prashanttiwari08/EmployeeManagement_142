package com.example.EmployeeManagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
        private List<Employee> e = new ArrayList<>();

        @GetMapping
        public List<Employee> getAll() {
            return e;
        }

        @PostMapping()
        public String addEmployee(@RequestBody Employee emp) {
            e.add(emp);
            return "Employee added Successfully!, Thank you!";
        }

        @PutMapping("/{id}")
        public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
            for(Employee emp: e){
                if(emp.getId() == id){
                    emp.setName(updatedEmployee.getName());
                    emp.setDepartment(updatedEmployee.getDepartment());
                    return "Employee Details Updated successfully";
                }
            }
            return "Employee Data is not updated";
        }

        @DeleteMapping("/{id}")
        public String deleteEmployee(@PathVariable int id) {
            boolean removed = e.removeIf(e -> e.getId() == id);
            if(removed){
                return "Employee deleted Successfully, Thank you!";
            }
            else {
                return "Employee data not deleted";
            }
        }
}

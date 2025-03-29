package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.DepartmentDto;
import net.javaguides.ems_backend.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    //BUILD ADD DEPARTMENT REST API
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dp = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(dp, HttpStatus.CREATED);
    }

    //BUILD GET DEPARTMENT BY ID REST API
    @PostMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto dp = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(dp, HttpStatus.OK);
    }

    //BUILD GET ALL DEPARTMENT REST API
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> deps = departmentService.getAllDepartments();
        return new ResponseEntity<>(deps, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto departmentDto){
        DepartmentDto dp = departmentService.updateDepartment(departmentId, departmentDto);
        return new ResponseEntity<>(dp, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}

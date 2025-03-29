package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.DepartmentDto;
import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.exception.ResourceNotFoundException;
import net.javaguides.ems_backend.mapper.DepartmentMapper;
import net.javaguides.ems_backend.repository.DepartmentRepository;
import net.javaguides.ems_backend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department dp = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id " + departmentId + " not found"));
        return DepartmentMapper.mapToDepartmentDto(dp);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> dep = departmentRepository.findAll();
        return dep.stream().map((d)->DepartmentMapper.mapToDepartmentDto(d)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department dp = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id " + departmentId + " not found"));
        dp.setName(departmentDto.getName());
        dp.setDescription(departmentDto.getDescription());
        Department savedDepartment = departmentRepository.save(dp);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department dp = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id " + departmentId + " not found"));
        departmentRepository.delete(dp);
    }
}

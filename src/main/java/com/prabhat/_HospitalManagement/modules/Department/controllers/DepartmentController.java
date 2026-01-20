package com.prabhat._HospitalManagement.modules.Department.controllers;

import com.prabhat._HospitalManagement.common.response.ApiResponse;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Department.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> createDepartment(
            @RequestBody DepartmentRequestDTO dto) {

        var department = departmentService.createDepartment(dto);

        return ResponseEntity.status(201).body(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Department created successfully")
                        .data(Map.of("department", department))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getDepartment(@PathVariable Long id) {

        var department = departmentService.getDepartmentById(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Department fetched successfully")
                        .data(Map.of("department", department))
                        .error(null)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllDepartments() {

        var departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Departments fetched successfully")
                        .data(Map.of("departments", departments))
                        .error(null)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentRequestDTO dto) {

        var department = departmentService.updateDepartment(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Department updated successfully")
                        .data(Map.of("department", department))
                        .error(null)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteDepartment(@PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Department deleted successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @PostMapping("/{id}/doctors/{doctorId}")
    public ResponseEntity<ApiResponse<Object>> addDoctor(
            @PathVariable Long id,
            @PathVariable Long doctorId) {

        departmentService.addDoctorToDepartment(id, doctorId);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Doctor added to department successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @DeleteMapping("/{id}/doctors/{doctorId}")
    public ResponseEntity<ApiResponse<Object>> removeDoctor(
            @PathVariable Long id,
            @PathVariable Long doctorId) {

        departmentService.removeDoctorFromDepartment(id, doctorId);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Doctor removed from department successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @PutMapping("/{id}/head/{doctorId}")
    public ResponseEntity<ApiResponse<Object>> assignHeadDoctor(
            @PathVariable Long id,
            @PathVariable Long doctorId) {

        departmentService.assignHeadDoctor(id, doctorId);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Head doctor assigned successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}/doctors")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getDepartmentDoctors(
            @PathVariable Long id) {

        var doctors = departmentService.getDepartmentDoctors(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Department doctors fetched successfully")
                        .data(Map.of("doctors", doctors))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}/head")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getHeadDoctor(
            @PathVariable Long id) {

        var headDoctor = departmentService.getHeadDoctor(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Head doctor fetched successfully")
                        .data(Map.of("headDoctor", headDoctor))
                        .error(null)
                        .build()
        );
    }

}

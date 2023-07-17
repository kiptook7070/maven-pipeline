package com.eclectics.io.mavenpipeline.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v3/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Department department) {
        try {
            return ResponseEntity.ok().body(departmentService.create(department));
        } catch (Exception e) {
            log.info("Caught Error" + e);
            return null;
        }
    }

    @GetMapping("/all")
    //defines a cache for method's return value
//    @Cacheable(value="all")
    @CacheEvict(value="departments", allEntries=true)
    public ResponseEntity<?> all() {
        try {
            return ResponseEntity.ok().body(departmentService.all());
        } catch (Exception e) {
            log.info("Caught Error" + e);
            return null;
        }
    }
    @GetMapping("/find/{id}")
    @Cacheable(value="departments", key="#id")
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(departmentService.find(id));
        } catch (Exception e) {
            log.info("Caught Error" + e);
            return null;
        }
    }
}

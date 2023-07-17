package com.eclectics.io.mavenpipeline.department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "SELECT id AS Id, department_code AS DepartmentCode FROM department ORDER BY department_code DESC LIMIT 1", nativeQuery = true)
    Optional<getDepartmentData> findDepartment();
    public interface getDepartmentData {
        Long getId();
        String getDepartmentCode();
    }

    Optional<Department> findByDepartmentName(String name);

    Page<Department> findByDepartmentCode(String departmentCode, Pageable pageable);

    Page<Department> findByDepartmentNameContaining(String name, Pageable pageable);

    List<Department> findByDepartmentCodeContaining(String code, Sort sort);
}

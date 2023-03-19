package com.example.DynamicSeats.repository;

        import com.example.DynamicSeats.dao.Employee;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByPhoneNumber(String phoneNumber);
    Employee findByDepartmentId(Integer departmentId);
//    Boolean existsByEmailAndPassword(String email, String password);
//    boolean existsByName(String name);
//    boolean existsByEmail(String email);
}
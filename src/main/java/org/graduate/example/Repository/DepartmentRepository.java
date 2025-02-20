package org.graduate.example.Repository;

import org.graduate.example.dox.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DepartmentRepository extends ReactiveCrudRepository<Department,String> {

}

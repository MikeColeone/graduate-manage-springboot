package org.graduate.example.Repository;

import org.graduate.example.dox.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface DepartmentRepository extends ReactiveCrudRepository<Department,String> {

    Mono<Department> findByName(String name);


}

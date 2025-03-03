package org.graduate.example.Repository;

import org.graduate.example.dox.Process;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProcessRepository extends ReactiveCrudRepository<Process,String> {
    @Query("select * from `my_process` p where p.department_id=:depId")
    Flux<Process> findByDepId(String depId);



    @Query("delete from my_process where id=:pid and department_id=:did")
    Mono<Void> deleteByIdAndDepId(String pid, String did);

}

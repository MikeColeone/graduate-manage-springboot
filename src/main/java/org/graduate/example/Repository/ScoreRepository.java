package org.graduate.example.Repository;

import org.graduate.example.dox.Score;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ScoreRepository extends ReactiveCrudRepository<Score,String> {

    @Query("SELECT * from my_process_score where student_id=:sid")
    Flux<Score> findByStudentId(String sid);


    @Query("SELECT * from my_process_score s where s.process_id =:group")
    Flux<Score> findByGroup(int group);

    @Query("SELECT * from my_process_score s where s.teacher_id->>'$.teacherId'=:tid")
    Flux<Score> findScoresByTid(String tid);

    @Modifying
    @Query("UPDATE my_process_score s set s.detail=:detail where s.id=:sid")
    Mono<Score> updateDetailById(String sid, String detail);

    @Query("SELECT * from my_process_score s where s.teacher_id =:group")
    Flux<Score> findScoresByGroup(int group);
}

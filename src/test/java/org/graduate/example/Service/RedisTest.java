package org.graduate.example.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.graduate.example.Repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test01(){
//        departmentRepository.findAll().map(Department::getDepId)
//                .doOnNext(depId-> log.debug("{}111111111111111111111111111111",depId)).blockLast();
        departmentRepository.findAll().doOnNext(
                department -> {
                    RBucket<Object> bucket = redissonClient.getBucket("process:"+department.getDepId(), StringCodec.INSTANCE);
                    bucket.set(department);
                }).blockLast();
//                .doOnNext(resultVO -> log.info("{}",resultVO)).block();
    }

    @Test
    void test02(){

        RBucket<Object> key = redissonClient.getBucket("key123", StringCodec.INSTANCE);
//        key.set(Map.of("key","value"));
        key.set(List.of("key","value"));
    }
}

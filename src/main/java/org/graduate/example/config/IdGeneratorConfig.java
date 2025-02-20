package org.graduate.example.config;
import com.github.yitter.contract.IdGeneratorOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.github.yitter.idgen.*;


@Component
public class IdGeneratorConfig {

    @PostConstruct
    public void init() {
        // 创建 IdGeneratorOptions
        IdGeneratorOptions options = new IdGeneratorOptions((short) 1);

        options.WorkerIdBitLength = 10;
        options.SeqBitLength = 6;
        options.BaseTime = 1700000000000L;
        YitIdHelper.setIdGenerator(options);
        System.out.println("ID 生成器初始化完成，WorkerId = " + options.WorkerId);

//        // 初始化后，在任何需要生成ID的地方，调用以下方法：
//        long newId = YitIdHelper.nextId();
    }
}

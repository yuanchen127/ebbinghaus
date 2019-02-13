package org.ike.ebbinghaus;


import lombok.extern.slf4j.Slf4j;
import org.ike.ebbinghaus.common.Ebbinghaus;
import org.ike.ebbinghaus.entity.Resource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @org.junit.Test
    public void test() {
        Resource resource = new Resource();
        Ebbinghaus ebs = new Ebbinghaus();
        ebs.memory(resource, true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("lastTime=>{}", sdf.format(resource.getLastTime()));
    }
}

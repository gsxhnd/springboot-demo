package xyz.gsxhnd.springboot-demo;

import xyz.gsxhnd.springboot-demo.util.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTtest {
    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    JWTUtil jwtUtil = new JWTUtil();



    @Test
    public void getJWT() {
        String token = jwtUtil.generateToken("123");
        logger.info("token" + token);
    }


}

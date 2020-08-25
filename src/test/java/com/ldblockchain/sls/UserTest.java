package xyz.gsxhnd.springboot-demo;


import xyz.gsxhnd.springboot-demo.api.entity.LdUser;
import xyz.gsxhnd.springboot-demo.api.mapper.LdUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private LdUserMapper userMapper;

//    EntityWrapper<User> qryWrapper = new EntityWrapper<>();

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<LdUser> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
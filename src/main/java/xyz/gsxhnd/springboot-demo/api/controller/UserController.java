package xyz.gsxhnd.springboot-demo.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import xyz.gsxhnd.springboot-demo.api.entity.LdUser;
import xyz.gsxhnd.springboot-demo.api.mapper.LdUserMapper;
import xyz.gsxhnd.springboot-demo.comm.enums.ResultCode;
import xyz.gsxhnd.springboot-demo.comm.result.ResponseResult;
import xyz.gsxhnd.springboot-demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-11-23
 */

@RestController
@RequestMapping("/api/v1/admin/user")
public class UserController{
    @Autowired
    private LdUserMapper ldUserMapper;

    @PostMapping("/login")
    public ResponseResult test(@RequestBody LdUser reqUser) {
        LdUser user = ldUserMapper.selectOne(new QueryWrapper<LdUser>().eq("username",reqUser.getUsername()));
        System.out.println(user);
        if (user != null && reqUser.getPassword().equals(user.getPassword())) {
            // 生成jwt
            JWTUtil jwtUtil = new JWTUtil();
            String token = jwtUtil.generateToken(user.getRole());

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token",token);

            return ResponseResult.success(jsonObject);
        } else {
            return ResponseResult.failure(ResultCode.USER_LOGIN_ERROR);
        }

    }
}

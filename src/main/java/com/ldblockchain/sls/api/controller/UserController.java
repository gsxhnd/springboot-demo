package com.ldblockchain.sls.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ldblockchain.sls.api.entity.LdUser;
import com.ldblockchain.sls.api.mapper.LdUserMapper;
import com.ldblockchain.sls.comm.enums.ResultCode;
import com.ldblockchain.sls.comm.result.ResponseResult;
import com.ldblockchain.sls.util.JWTUtil;
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

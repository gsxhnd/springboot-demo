package com.ldblockchain.sls.api.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.ldblockchain.sls.api.entity.LdUser;
import com.ldblockchain.sls.api.mapper.LdUserMapper;
import com.ldblockchain.sls.comm.enums.ResultCode;
import com.ldblockchain.sls.comm.result.ResponseResult;
import com.ldblockchain.sls.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Component;
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
@RequestMapping("/api/v1/admin")
public class test{

    @GetMapping("/test")
    public ResponseResult test() {
        return ResponseResult.success();

    }
}

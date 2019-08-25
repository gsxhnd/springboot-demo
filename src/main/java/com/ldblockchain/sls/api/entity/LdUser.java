package com.ldblockchain.sls.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2018-11-23
 */
@Data
//@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LdUser {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String role;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}

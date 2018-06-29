package com.xiedcode.ssm.main;

import java.io.Serializable;
import java.util.List;

import com.xiedcode.ssm.pojo.Role;
import com.xiedcode.ssm.mapper.RoleMapper;
import com.xiedcode.ssm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * main，程序入口，主要用于在main中执行个个接口的函数
 *
 * @author xd
 * Created on 2018/6/21 22:43
 */
public class MainSession implements Serializable {
    private static final long serialVersionUID = 3591955829033751969L;

    public static void main(String[] args) {
        Logger log = Logger.getLogger(MainSession.class);
        SqlSession session = null;
        try {
            session = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setName("Bob");
            role.setNote("家住隔壁");
            session.insert("com.xiedcode.ssm.mapper.RoleMapper.insertRole", role);
            role.setNote("hhh");
            roleMapper.insertRole(role);
            session.commit();
            List<Role> roles = session.getMapper(RoleMapper.class).findRoles("Bob");
            for (Role role1: roles) {
                log.info(role1.getNote());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

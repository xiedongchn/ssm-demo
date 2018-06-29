package com.xiedcode.ssm.mapper.impl;

import com.xiedcode.ssm.pojo.Role;
import com.xiedcode.ssm.mapper.RoleMapper;
import com.xiedcode.ssm.utils.SqlSessionFactoryManually;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * RoleMapper接口实现类
 *
 * @author xd
 * Created on 2018/6/19 11:42
 */
public class RoleMapperImpl implements RoleMapper {

    public Role getRoleById(Long id) {
        SqlSession session = null;
        try {
            //打开SqlSession会话
            session = SqlSessionFactoryManually.getSqlSessionFactory().openSession();
            session.getMapper(RoleMapper.class).getRoleById(1L);
            session.selectOne("getRoleById", 1L);
            //sql逻辑
            session.commit();//提交事务
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public int insertRole(Role role) {
        return 0;
    }

    public int deleteRole(Long id) {
        return 0;
    }

    public int updateRole(Role role) {
        return 0;
    }

    public List<Role> findRoles(String name) {
        return null;
    }
}

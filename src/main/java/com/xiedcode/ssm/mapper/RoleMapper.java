package com.xiedcode.ssm.mapper;

import com.xiedcode.ssm.pojo.Role;

import java.util.List;

/**
 * 角色映射器
 *
 * @author xd
 * Created on 2018/6/18 22:31
 */
public interface RoleMapper {

    /**
     * get role by id
     * @param id pri key
     * @return Role
     */
    public Role getRoleById(Long id);

    /**
     * save role
     * @param role Role
     * @return int
     */
    public int insertRole(Role role);

    /**
     * delete role by id
     * @param id pri key
     * @return int
     */
    public int deleteRole(Long id);

    /**
     * update role
     * @param role Role
     * @return int
     */
    public int updateRole(Role role);

    /**
     * find role by role name
     * @param name role name
     * @return collection of roles
     */
    public List<Role> findRoles(String name);
}

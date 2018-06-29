package com.xiedcode.ssm.utils;

import com.xiedcode.ssm.pojo.Role;
import com.xiedcode.ssm.mapper.RoleMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * 通过代码的方式创建SqlSessionFactory
 *
 * @author xd
 * Created on 2018/6/18 22:22
 */
public class SqlSessionFactoryManually {

    /**
     * 构造方法私有化
     */
    private SqlSessionFactoryManually() {}

    /**
     * 获取sql回话工厂对象
     *
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        //数据库连接池信息
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.driver");
        dataSource.setUsername("root");
        dataSource.setPassword("654321");
        dataSource.setUrl("jdbc.mysql://localhost:3306/ssm");
        dataSource.setDefaultAutoCommit(false);
        //采用MyBatis的JDBC事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        //创建Configuration对象
        Configuration configuration = new Configuration(environment);
        //注册一个mybatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        //加入一个映射器
        configuration.addMapper(RoleMapper.class);
        //使用SqlSessionFactoryBuilder构建SqlSessionFactory
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}

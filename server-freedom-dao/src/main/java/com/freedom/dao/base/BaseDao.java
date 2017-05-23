package com.freedom.dao.base;

import com.freedom.base.BaseEntity;

import java.util.List;

/**
 * 创建用户:wangchuanhai
 * 创建时间:2017/5/23
 * -----------------------------------------------------
 * 版本   描述
 * v1.0   新建
 * <p>
 * ------------------------------------------------------
 */
public interface BaseDao<T extends BaseEntity> {
    // 添加单个实例
    public static String INSERT = "insert";
    // 更新单个实例
    public static String UPDATE = "update";
    // 删除单个实例
    public static String DELETE = "delete";
    // 获取单个实例
    public static String SELECT_ONE = "selectOne";
    // 获取多个实例
    public static String SELECT_LIST = "selectList";

    /**
     * 添加单个实例
     * @param t
     * @return
     */
    public abstract int insert(T t);

    /**
     * 更新单个实例
     * @param t
     * @return
     */
    public abstract int update(T t);

    /**
     * 删除单个实例
     * @param t
     * @return
     */
    public abstract int delete(T t);

    /**
     * 获取单个实例
     * @param t
     * @return
     */
    public abstract T selectOne(T t);

    /**
     * 获取多个实例
     * @param t
     * @return
     */
    public abstract List selectList(T t);
}

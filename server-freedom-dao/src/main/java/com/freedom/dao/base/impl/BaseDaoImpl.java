package com.freedom.dao.base.impl;

import com.freedom.base.BaseEntity;
import com.freedom.dao.base.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 创建用户:wangchuanhai
 * 创建时间:2017/5/23
 * ----------------------------------------------------
 * 版本   描述
 * v1.0   新建
 * <p>
 * ----------------------------------------------------
 */
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    public abstract String getNameSpace();

    @Override
    public int insert(T t) {
        Date date = new Date();
        t.setCreateTime(date);
        t.setUpdateTime(date);
        return this.sqlSessionTemplate.insert(this.getNameSpace() + "." + INSERT,t);
    }

    @Override
    public int update(T t) {
        Date date = new Date();
        t.setUpdateTime(date);
        return this.sqlSessionTemplate.update(this.getNameSpace() + "." + UPDATE,t);
    }

    @Override
    public int delete(T t) {
        if (null == t) {
            return -1;
        }
        return this.sqlSessionTemplate.delete(this.getNameSpace() + "." + DELETE,t);
    }

    @Override
    public T selectOne(T t) {
        if (null == t) {
            return null;
        }
        return this.sqlSessionTemplate.selectOne(this.getNameSpace() + "." + SELECT_ONE,t);
    }

    @Override
    public List<T> selectList(T t) {
        if (null == t) {
            return null;
        }
        return this.sqlSessionTemplate.selectList(this.getNameSpace() + "." + SELECT_LIST,t);
    }

}

package com.ants.dal.base;

import java.util.List;

import com.ants.dal.page.PageParams;
import com.ants.dal.page.PageResult;

/**
* @Description: DAO基类
* @author smatiger
* @date 2017年4月24日 下午4:03:52 
*/
public interface BaseDao<T extends BaseDo> {

    /**
    * @Description: 根据ID查询单个对象
    * @author smatiger
    * @param id 主键ID
    * @return 对象
    * @throws
    */
    public T getById(Long id);

    /**
    * @Description: 查询全部记录
    * @author smatiger
    * @return 所有记录集合
    * @throws
    */
    public List<T> queryAll();

    /**
    * @Description: 根据条件查询记录
    * @author smatiger
    * @param param 对象实体
    * @return 符合条件的结果集合
    * @throws
    */
    public List<T> queryByParam(T param);

    /**
    * @Description: 分页查询对象
    * @author smatiger
    * @param params 查询参数
    * @return 分页对象
    * @throws
    */
    public PageResult<T> queryForPage(PageParams params);

    /**
    * @Description: 新增记录
    * @author smatiger
    * @param param 新增对象入参，DO
    * @return 受影响的记录数
    * @throws
    */
    public int insert(T param);

    /**
    * @Description: 更新记录
    * @author smatiger
    * @param param 更新对象
    * @return 受影响的记录数
    * @throws
    */
    public int update(T param);

    /**
    * @Description: 删除对象
    * @author smatiger
    * @param id 主键ID
    * @return 受影响的记录数
    * @throws
    */
    public int delete(Long id);

    /**
    * @Description: 批量新增
    * @author smatiger
    * @param list 要新增的对象集合
    * @throws
    */
    public void insertBatch(List<T> list);

    /**
    * @Description: 批量更新
    * @author smatiger
    * @param list 需要更新的对象集合
    * @throws
    */
    public void updateBatch(List<T> list);
}
package com.yutian.zhang.rental.common.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.dto.QueryCondition;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * BaseEntity
 * @descrition Provide basic entities
 * @author Yutian Zhang
 * @date 17/12/2021 12:58
 */

public interface BaseService<E, ID extends Serializable> {


    BaseMapper<E> getRepository();

    /**
     * Get something by id
     *
     * @param id
     * @return
     */
    default E get(ID id) {
        return getRepository().selectById(id);
    }

    /**
     * Get everything in a list
     *
     * @return
     */
    default List<E> getAll() {
        return getRepository().selectList(null);
    }

    /**
     * Get total number
     *
     * @return
     */
    default Integer getTotalCount() {
        return getRepository().selectCount(null);
    }

    /**
     * Insert function
     *
     * @param entity
     * @return
     */
    default E insert(E entity) {

        getRepository().insert(entity);
        return entity;
    }

    /**
     * Update function
     *
     * @param entity
     * @return
     */
    default E update(E entity) {
        getRepository().updateById(entity);
        return entity;
    }

    /**
     * Save and update function
     *
     * @param entity
     * @return
     */
    default E insertOrUpdate(E entity) {
        try {
            Object id = entity.getClass().getMethod("getId").invoke(entity);
            if (id != null) {
                update(entity);
            } else {
                insert(entity);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * Batch save and modify
     *
     * @param list
     * @return
     */
    default List<E> batchInsert(List<E> list) {
        for (E e : list) {
            getRepository().insert(e);
        }
        return list;
    }


    /**
     * Delete by ID
     *
     * @param id
     */
    default void delete(ID id) {
        getRepository().deleteById(id);
    }

    /**
     * Batch delete
     *
     * @param ids
     */
    default void batchDelete(List<ID> ids) {
        getRepository().deleteBatchIds(ids);
    }


    /**
     * Batch search
     *
     * @param ids
     * @return
     */
    default List<E> findByBatchIds(List<ID> ids) {
        return getRepository().selectBatchIds(ids);
    }

    /**
     * Get everything
     *
     * @return
     */
    default List<E> findAll() {
        return getRepository().selectList(null);
    }

    /**
     * Search by condition
     *
     * @param queryWrapper
     * @return
     */
    default List<E> findAll(QueryWrapper<E> queryWrapper) {
        return getRepository().selectList(queryWrapper);
    }

    /**
     * Search without pagination
     *
     * @param condition
     * @return
     */
    default List<E> findAll(QueryCondition<E> condition) {
        E e = condition.getData();

        QueryWrapper<E> queryWrapper = getQueryWrapper(e);

        return getRepository().selectList(queryWrapper);
    }

    /**
     * Search with pagination
     *
     * @param page
     * @return
     */
    default Page<E> findAll(Page<E> page) {
        return (Page<E>) getRepository().selectPage(page, null);
    }

    /**
     * Conditional Constructor
     *
     * @param e
     * @return
     */
    QueryWrapper<E> getQueryWrapper(E e);

    /**
     * Conditional Constructor
     *
     * @param condition
     * @return
     */
    QueryWrapper<E> getQueryWrapper(Map<String, Object> condition);

    /**
     * Pagination with conditions
     *
     * @param page
     * @param e
     * @return
     */
    default Page<E> findAll(Page<E> page, E e) {

        QueryWrapper<E> queryWrapper = getQueryWrapper(e);

        return (Page<E>) getRepository().selectPage(page, queryWrapper);
    }

    /**
     * Pagination with conditions
     *
     * @param page
     * @param queryWrapper
     * @return
     */
    default Page<E> findAll(Page<E> page, QueryWrapper queryWrapper) {

        return (Page<E>) getRepository().selectPage(page, queryWrapper);
    }

    /**
     * Pagination with conditions
     *
     * @param page
     * @param condition
     * @return
     */
    default Page<E> findAll(Page<E> page, Map<String, Object> condition) {

        QueryWrapper<E> queryWrapper = getQueryWrapper(condition);

        return (Page<E>) getRepository().selectPage(page, queryWrapper);
    }

    /**
     * Get number of results
     *
     * @param queryWrapper
     * @return
     */
    default long count(QueryWrapper<E> queryWrapper) {
        return getRepository().selectCount(queryWrapper);
    }

}


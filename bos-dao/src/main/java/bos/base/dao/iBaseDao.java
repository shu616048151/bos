package bos.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bos.utils.PageBean;


public interface iBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...objects);
	public PageBean Query(PageBean pageBean);
	public List<T> findListByCriteria(DetachedCriteria criteria);
}

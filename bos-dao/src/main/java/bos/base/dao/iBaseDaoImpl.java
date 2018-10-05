package bos.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.poifs.storage.BATBlock.BATBlockAndIndex;
import org.apache.xml.resolver.apps.resolver;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bos.utils.PageBean;


public class iBaseDaoImpl<T> extends HibernateDaoSupport implements iBaseDao<T>{
	

	private Class<T> entityclass;
	public iBaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] actualTypeArguments = ((ParameterizedType)genType).getActualTypeArguments();
		entityclass=(Class<T>) actualTypeArguments[0];
	}
	//从applicationcontext.xml中注入sessionfactory
	@Resource
	public void setSessionFactoty(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityclass, id);
	}
	@Override
	public List<T> findAll() {
		String hql="from "+entityclass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}
	
	public void executeUpdate(String queryName, Object... objects) {
		//得到当前的session
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query query = currentSession.getNamedQuery(queryName);
		int i=0;
		for (Object object : objects) {
			query.setParameter(i++, object.toString());
		}
		query.executeUpdate();
		
		
	}
	@Override
	public PageBean Query(PageBean pageBean) {
		//查询总数
		DetachedCriteria criteria=pageBean.getDetachedCriteria();
		criteria.setProjection(Projections.rowCount());
		List<Long> totaList = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		int total = totaList.get(0).intValue();
		pageBean.setTotal(total);
		//计算分页查询
		int page=pageBean.getCurrentPage();
		int pageSize=pageBean.getPageSize();
		criteria.setProjection(null);
		criteria.setResultTransformer(criteria.ROOT_ENTITY);
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (page-1)*pageSize, pageSize);
		pageBean.setRows(list);
		return pageBean;
	}
	@Override
	public List<T> findListByCriteria(DetachedCriteria criteria) {
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
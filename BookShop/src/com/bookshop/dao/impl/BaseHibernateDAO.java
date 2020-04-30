package com.bookshop.dao.impl;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bookshop.utils.PageResults;




/**
 * 通用hibernate base dao
 * 
 * @author Administrator
 * @param <T>
 */
@Repository
public abstract class BaseHibernateDAO<T> {
	private Class clazz;
	private String clazzName;
	private Session session = null;
	@Resource
	private HibernateTemplate hibernateTemplate;

	public BaseHibernateDAO() {
		// 使用反射的方式获得类名（表名）
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] tps = pt.getActualTypeArguments();
			if (tps.length > 0) {
				this.clazz = (Class) tps[0];
				this.clazzName = clazz.getName();
			}
		}
	}

	/**
	 * 插入t
	 * 
	 * @return
	 */
	protected T saveOrUpdate(T t) {
		hibernateTemplate.saveOrUpdate(t);
		return t;
	}

	/**
	 * 根据ID获取对象
	 * 
	 * @param id
	 * @return
	 */
	protected T get(Serializable id) {
		T item = null;
		item = (T) hibernateTemplate.get(this.clazz, id);//load
		return item;
	}

	/**
	 * 根据ID获取对象(支持延迟加载)
	 * @param id
	 * @return
	 */
	protected T load(Serializable id) {
		T item = null;
		item = (T) hibernateTemplate.load(this.clazz, id);//load
		return item;
	}
	
	
	/**
	 * 获取所有数据
	 * 
	 * @return
	 */
	protected List<T> getAll() {
		System.out.println("******"+clazzName);
		return (List<T>)hibernateTemplate.find("from " + clazzName);
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 */
	protected int del(Serializable id) {
		Transaction tx = null;
		int result = 0;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			Query q = getSession().createQuery(
					"delete from " + clazzName + " where id = ?");
			result = q.setParameter(0, id).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (null != tx) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			closeSession();
		}
		
		return result;
	}

	/**
	 * 删除对象
	 * 
	 * @param t
	 */
	protected void delete(T t) {
		hibernateTemplate.delete(t);
	}

	/**
	 * 根据HQL查询List
	 * 
	 * @param hql
	 * @return
	 */
	protected List<T> find(String hql) {
		return hibernateTemplate.find(hql);
	}

	/**
	 * <根据HQL语句查找唯一实体>
	 * 
	 * @param hqlString
	 *            HQL
	 * @param values
	 *            不定参数数组
	 * @return
	 */
	protected T getByHQL(String hqlString, Object... values) {
		Session session = getSession();
		T t = null;
		try {
			Query query = session.createQuery(hqlString);
			
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
			t = (T) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return t;
	}

	/**
	 * <根据SQL语句查找唯一实体>
	 * 
	 * @param sqlString
	 *            SQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return
	 */
	protected T getBySQL(String sqlString, Object... values) {
		Session session = getSession();
		T t = null;
		try {
			Query query = session.createSQLQuery(sqlString);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
			t = (T) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return t;
	}

	/**
	 * <根据HQL语句，得到对应的list>
	 * 
	 * @param hqlString
	 *            HQL语句
	 * @param values
	 * @return
	 */
	protected List<T> getListByHQL(String hqlString, Object... values) {
		Session session = getSession();
		List<T> list = new ArrayList<T>();
		try {
			Query q = session.createQuery(hqlString);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					q.setParameter(i, values[i]);
				}
			}
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return list;
	}

	/**
	 * <根据SQL语句，得到对应的list>
	 * 
	 * @param sqlString
	 * @param values
	 * @return
	 */
	protected List<T> getListBySQL(String sqlString, Object... values) {
		Session session = getSession();
		List<T> list = new ArrayList<T>();
		try {
			Query q = session.createSQLQuery(sqlString);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					q.setParameter(i, values[i]);
				}
			}
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return list;
	}

	/**
	 * <根据HQL得到记录数>
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	protected Long countByHql(String hql, Object... values) {
		Session session = getSession();
		Long t = null;
		try {
			Query query = session.createQuery(hql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
			t = (Long) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return t;
	}

	/**
	 * <HQL分页查询>
	 * 
	 * @param hql
	 * @param countHql
	 *            查询记录条数的HQL语句
	 * @param pageNo
	 *            下一页
	 * @param pageSize
	 *            一页总条数
	 * @param values
	 * @return
	 */

	protected PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object... values) {
		PageResults<T> retValue = new PageResults<T>();
		Session session = getSession();
		Long t = null;
		try {
			Query query = session.createQuery(hql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}

			int currentPage = pageNo > 1 ? pageNo : 1;
			retValue.setCurrentPage(currentPage);
			retValue.setPageSize(pageSize);
			if (countHql == null) {
				ScrollableResults results = query.scroll();
				results.last();
				retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
			} else {
				Long count = countByHql(countHql, values);
				retValue.setTotalCount(count.intValue());
			}
			retValue.resetPageNo();
			List<T> itemList = query
					.setFirstResult((currentPage - 1) * pageSize)
					.setMaxResults(pageSize).list();
			if (itemList == null) {
				itemList = new ArrayList<T>();
			}
			retValue.setResults(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}

		return retValue;
	}

	/**
	 * Criteria方式查询
	 * 
	 * @param condition
	 * @return
	 */
	protected List<T> queryByCriteria(Criterion condition) {
		try {
			List<T> results = getSession().createCriteria(this.clazz)
					.add(condition).list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			closeSession();
		}
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		if (this.session == null)
			this.session = hibernateTemplate.getSessionFactory().openSession();
		else
			this.session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return this.session;
	}

	public void closeSession() {
		this.session.close();
		this.session = null;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}

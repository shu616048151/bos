package bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.SubareaDao;
import bos.domain.Subarea;
import bos.service.SubareaService;
import bos.utils.PageBean;
@Service
@Transactional
public class SubareaServiceIpml implements SubareaService{
	
	@Autowired
	private SubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}

	@Override
	public void query(PageBean pageBean) {
		subareaDao.Query(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}
	@Override
	public List<Subarea> findListNoAssociation() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Subarea.class);
		criteria.add(Restrictions.isNull("decideZone"));
		return subareaDao.findListByCriteria(criteria);
	}

	@Override
	public List<Subarea> findListByDecidedId(String id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Subarea.class);
		criteria.add(Restrictions.eq("decideZone.id", id));
		return subareaDao.findListByCriteria(criteria);
	}

}

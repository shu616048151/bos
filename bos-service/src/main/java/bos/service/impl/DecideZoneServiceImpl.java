package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.DecideZoneDao;
import bos.dao.SubareaDao;
import bos.domain.DecideZone;
import bos.domain.Subarea;
import bos.service.DecideZoneService;
import bos.utils.PageBean;
@Service
@Transactional
public class DecideZoneServiceImpl implements DecideZoneService {
	@Autowired
	private DecideZoneDao decideZoneDao;
	@Autowired
	private SubareaDao subareaDao;

	@Override
	public void save(DecideZone model,String[] subareaid) {
		//保存数据
		decideZoneDao.save(model);
		//为其添加多的一方
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//多的一方添加到一的一方，一的一方放弃外键维护权
			subarea.setDecideZone(model);
		}
	}

	@Override
	public void list(PageBean pageBean) {
		decideZoneDao.Query(pageBean);
	}
}

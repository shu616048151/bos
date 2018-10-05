package bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.RegionDao;
import bos.domain.Region;
import bos.service.RegionService;
import bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionDao regionDao;

	@Override
	public void save(Region region) {
		regionDao.save(region);
	}

	@Override
	public void list(PageBean pageBean) {
		regionDao.Query(pageBean);
	}

	@Override
	public List<Region> regList() {
		return regionDao.findAll();
	}

}

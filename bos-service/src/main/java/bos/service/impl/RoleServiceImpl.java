package bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.RoleDao;
import bos.domain.Function;
import bos.domain.Role;
import bos.service.RoleService;
import bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public void save(Role role, String functionIds) {
		roleDao.save(role);
		if (StringUtils.isNotBlank(functionIds)) {
			String[] fds = functionIds.split(",");
			for (String id : fds) {
				Function function=new Function(id);
				role.getFunctions().add(function);
			}
		}
	}

	@Override
	public void pageBean(PageBean pageBean) {
		roleDao.Query(pageBean);
		
	}
	@Override
	public List<Role> findRoleAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}

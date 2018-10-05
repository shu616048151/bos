package bos.service;

import java.util.List;

import bos.domain.Role;
import bos.utils.PageBean;

public interface RoleService {

	public void save(Role model, String functionIds);

	public void pageBean(PageBean pageBean);

	public List<Role> findRoleAll();

}

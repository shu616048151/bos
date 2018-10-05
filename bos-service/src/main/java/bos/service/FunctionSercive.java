package bos.service;

import java.util.List;

import bos.domain.Function;
import bos.utils.PageBean;

public interface FunctionSercive {

	public List<Function> findAll();

	public void save(Function model);

	public void query(PageBean pageBean);

}

package bos.service;

import java.util.List;

import bos.domain.Subarea;
import bos.utils.PageBean;

public interface SubareaService {

	public void save(Subarea model);

	public void query(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findListNoAssociation();

	public List<Subarea> findListByDecidedId(String id);

}

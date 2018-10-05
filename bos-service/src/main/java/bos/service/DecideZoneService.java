package bos.service;

import bos.domain.DecideZone;
import bos.utils.PageBean;

public interface DecideZoneService {

	public void save(DecideZone model, String[] subareaid);

	public void list(PageBean pageBean);

}

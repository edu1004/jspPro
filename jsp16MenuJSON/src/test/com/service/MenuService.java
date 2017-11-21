package test.com.service;

import java.util.List;

import test.com.model.MenuDAO;
import test.com.model.MenuDAOimpl;
import test.com.model.MenuVO;

public class MenuService {
	
	private MenuDAO dao = new MenuDAOimpl();

	public int insert(MenuVO vo) {
		return dao.insert(vo);
	}

	public int update(MenuVO vo){
		return dao.update(vo);
	}

	public int delete(MenuVO vo){
		return dao.delete(vo);
	}

	public List<MenuVO> selectAll(){
		return dao.selectAll();
	}

	public MenuVO selectOne(MenuVO vo){
		return dao.selectOne(vo);
	}
	
}

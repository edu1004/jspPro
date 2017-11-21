package test.com.model;

import java.util.List;

public interface MenuDAO {

	public int insert(MenuVO vo);

	public int update(MenuVO vo);

	public int delete(MenuVO vo);

	public List<MenuVO> selectAll();

	public MenuVO selectOne(MenuVO vo);

}

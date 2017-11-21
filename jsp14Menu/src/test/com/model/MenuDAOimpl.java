package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOimpl implements MenuDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "admin";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into menu(num,menu,price,store,kcal) " 
								+ "values(seq_menu_num.nextval,?,?,?,?)";
	private final String SQL_SELECT_ALL = "select * from menu order by num desc";
	private final String SQL_SELECT_ONE = "select * from menu where num=?";
	private final String SQL_UPDATE = "update menu set menu=?,price=?,store=?,kcal=? where num=?";
	private final String SQL_DELETE = "delete from menu where num=?";

	public MenuDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MenuVO vo) {
		System.out.println("insert(MenuVO vo).....");
		System.out.println(vo.getMenu());
		System.out.println(vo.getPrice());
		System.out.println(vo.getStore());
		System.out.println(vo.getKcal());
		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getMenu());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getStore());
			pstmt.setInt(4, vo.getKcal());
			
			flag = pstmt.executeUpdate();
			System.out.println("insert flag:"+flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public int update(MenuVO vo) {
		System.out.println("update(MenuVO vo).....");
		System.out.println(vo.getNum());
		System.out.println(vo.getMenu());
		System.out.println(vo.getPrice());
		System.out.println(vo.getStore());
		System.out.println(vo.getKcal());
		
		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getMenu());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getStore());
			pstmt.setInt(4, vo.getKcal());
			pstmt.setInt(5, vo.getNum());
			
			flag = pstmt.executeUpdate();
			System.out.println("update flag:"+flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public int delete(MenuVO vo) {
		System.out.println("delete(MenuVO vo).....");
		System.out.println(vo.getNum());
		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			
			flag = pstmt.executeUpdate();
			System.out.println("delete flag:"+flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public List<MenuVO> selectAll() {
		System.out.println("selectAll().....");
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setNum(rs.getInt("num"));
				vo.setMenu(rs.getString("menu"));
				vo.setPrice(rs.getInt("price"));
				vo.setStore(rs.getString("store"));
				vo.setKcal(rs.getInt("kcal"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}

	@Override
	public MenuVO selectOne(MenuVO vo) {
		System.out.println("selectOne(MenuVO vo).....");
		System.out.println(vo.getNum());
		MenuVO mvo = new MenuVO();
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvo.setNum(rs.getInt("num"));
				mvo.setMenu(rs.getString("menu"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setStore(rs.getString("store"));
				mvo.setKcal(rs.getInt("kcal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return mvo;
	}

}

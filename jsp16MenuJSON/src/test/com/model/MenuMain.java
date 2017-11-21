package test.com.model;

import java.util.List;

public class MenuMain {

	public static void main(String[] args) {
		System.out.println("menu....");

		//
		// //1.insert
		// MenuDAO dao = new MenuDAOimpl();
		// MenuVO vo = new MenuVO();
		// vo.setMenu("chasubanto");
		// vo.setPrice(10000);
		// vo.setStore("ich");
		// vo.setKcal(900);
		// int result = dao.insert(vo);
		// if(result==1) {
		// System.out.println("insert successed");
		// }else {
		// System.out.println("insert failed");
		// }
		///////////////////////////////////////

		// //2.select
		// MenuDAO dao = new MenuDAOimpl();
		// List<MenuVO> list = dao.selectAll();
		// System.out.println("list.size():"+list.size());

		// 3.selectOne
		// MenuDAO dao = new MenuDAOimpl();
		// MenuVO vo = new MenuVO();
		// vo.setNum(9);
		// MenuVO mvo = dao.selectOne(vo);
		// System.out.println(mvo.getNum());
		// System.out.println(mvo.getMenu());
		// System.out.println(mvo.getPrice());
		// System.out.println(mvo.getStore());
		// System.out.println(mvo.getKcal());

		// 4.update
		// MenuDAO dao = new MenuDAOimpl();
		// MenuVO vo = new MenuVO();
		// vo.setNum(6);
		// vo.setMenu("aaa");
		// vo.setPrice(888);
		// vo.setStore("ich88");
		// vo.setKcal(888);
		// int result = dao.update(vo);
		// if (result == 1) {
		// System.out.println("update successed");
		// } else {
		// System.out.println("update failed");
		// }

		// 5.delete
		MenuDAO dao = new MenuDAOimpl();
		MenuVO vo = new MenuVO();
		vo.setNum(6);
		int result = dao.delete(vo);
		if (result == 1) {
			System.out.println("delete successed");
		} else {
			System.out.println("delete failed");
		}
	}

}

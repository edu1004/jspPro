package test.com.model;

import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {

	@Override
	public TestVO jselectOne(TestVO vo) {
		System.out.println(vo.getName());
		
		
		TestVO tvo = new TestVO();
		tvo.setName("lee");
		tvo.setAge(22);
		return tvo;
	}

	@Override
	public List<TestVO> jselectAll() {
		List<TestVO> list  = new ArrayList<>();
		TestVO vo = new TestVO();
		vo.setAge(11);
		vo.setName("kim");
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		return list;
	}

}

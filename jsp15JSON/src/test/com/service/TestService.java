package test.com.service;

import java.util.List;

import test.com.model.TestDAO;
import test.com.model.TestDAOimpl;
import test.com.model.TestVO;

public class TestService {
	
	private TestDAO dao = new TestDAOimpl();
	
	public List<TestVO> jselectAll(){
		return dao.jselectAll();
	}
	public TestVO jselectOne(TestVO vo){
		
		return dao.jselectOne(vo);
	}

}

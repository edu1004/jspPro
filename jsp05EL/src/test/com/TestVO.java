package test.com;

public class TestVO {

	private String id;
	private String pw;
	
	public TestVO() {
		id = "admin";
		pw = "hi123456";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}

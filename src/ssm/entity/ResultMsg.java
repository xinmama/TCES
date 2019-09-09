package ssm.entity;

public class ResultMsg {

	private int flag;//标识
	private String content;//内容
	
	public ResultMsg(int flag,String content) {
		this.flag=flag;
		this.content=content;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}

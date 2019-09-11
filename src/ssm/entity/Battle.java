package ssm.entity;

public class Battle {

	private int id;
	private int player1_id;
	private int player2_id;
	private String song1;
	private String song2;
	private int ticket1;
	private int ticket2;
	private int status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayer1_id() {
		return player1_id;
	}
	public void setPlayer1_id(int player1_id) {
		this.player1_id = player1_id;
	}
	public int getPlayer2_id() {
		return player2_id;
	}
	public void setPlayer2_id(int player2_id) {
		this.player2_id = player2_id;
	}
	public String getSong1() {
		return song1;
	}
	public void setSong1(String song1) {
		this.song1 = song1;
	}
	public String getSong2() {
		return song2;
	}
	public void setSong2(String song2) {
		this.song2 = song2;
	}
	public int getTicket1() {
		return ticket1;
	}
	public void setTicket1(int ticket1) {
		this.ticket1 = ticket1;
	}
	public int getTicket2() {
		return ticket2;
	}
	public void setTicket2(int ticket2) {
		this.ticket2 = ticket2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

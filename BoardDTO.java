package new_board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDTO {
	private int id;
	private String detail;
	private String start_at;


	public String toString() {
		return super.toString()
				+ ",id=" + id
				+ ",detail=" + detail
				+ "start_at" + start_at
				;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStart_at() {
		return start_at;
	}
	public void setStart_at(Date start_at) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.start_at = df.format(start_at);;
	}

}

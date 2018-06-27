package Teachium.Teachium.domain;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Message {
	
	@Id
	private String id;
	private Date date = new Date();
	private String object;
	private Boolean read = false;
	
	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	private String text;
	private String from;
	private String to;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Message(String text, String from, String to) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.from = from;
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

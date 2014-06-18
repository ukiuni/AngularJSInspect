package org.ukiuni.inspect.angularjs.entity;

public class Memo {
	private long id;
	private String text;

	public Memo() {

	}

	public Memo(long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

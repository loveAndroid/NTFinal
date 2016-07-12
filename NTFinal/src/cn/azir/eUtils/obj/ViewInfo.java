package cn.azir.eUtils.obj;

import java.lang.reflect.Field;

public class ViewInfo {

	private int id;
	private String onClick;
	private String onItemClick;
	private String onLongClick;
	private String onItemLongClick;
	private Object source;
	private Field field;
	
	
	public Field getField() {
		return field;
	}

	public ViewInfo setField(Field field) {
		this.field = field;
		return this;
	}

	public Object getSource() {
		return source;
	}

	public ViewInfo setSource(Object source) {
		this.source = source;
		return this;
	}

	public int getId() {
		return id;
	}

	public ViewInfo setId(int id) {
		this.id = id;
		return this;
	}

	public String getOnClick() {
		return onClick;
	}

	public ViewInfo setOnClick(String onClick) {
		this.onClick = onClick;
		return this;
	}

	public String getOnItemClick() {
		return onItemClick;
	}

	public ViewInfo setOnItemClick(String onItemClick) {
		this.onItemClick = onItemClick;
		return this;
	}

	public String getOnLongClick() {
		return onLongClick;
	}

	public ViewInfo setOnLongClick(String onLongClick) {
		this.onLongClick = onLongClick;
		return this;
	}

	public String getOnItemLongClick() {
		return onItemLongClick;
	}

	public ViewInfo setOnItemLongClick(String onItemLongClick) {
		this.onItemLongClick = onItemLongClick;
		return this;
	}

}

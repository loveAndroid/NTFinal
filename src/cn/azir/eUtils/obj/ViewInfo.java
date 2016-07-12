/**
 * Copyright 2016/07/12 . kongxs1017@gmail.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
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

package com.test.slider.data;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Table;

public class DataInfo {
	private int start = 0;
	private int end = 0;
	private boolean isFirst =false;
	private boolean isScale = false;

	public DataInfo(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public DataInfo(int start, int end, boolean isFirst) {
		this.start = start;
		this.end = end;
		this.isFirst = isFirst;
	}
	
	public DataInfo(int start, int end, boolean isFirst,boolean isScale) {
		this.start = start;
		this.end = end;
		this.isFirst = isFirst;
		this.isScale = isScale;
	}

	public void setValues(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
	public boolean isFirst() {
		return isFirst;
	}
	
	/*public boolean isScale(){
		return isScale;
	}*/
}



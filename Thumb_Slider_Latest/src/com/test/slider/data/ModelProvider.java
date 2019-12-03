package com.test.slider.data;

import java.util.ArrayList;
import java.util.List;



public enum ModelProvider {
	INSTANCE;

	Person person;
	DataInfo info;
	private int start = 0;
	private int end = 0;
	private boolean isFirst = false;
	//private boolean isScale = false;

	public List<Person> getPersons(Object element) {
		info = (DataInfo)element;
		start=info.getStart();
		end=info.getEnd();
		isFirst = info.isFirst();
		//isScale = info.isScale();
		
		if(isFirst){
			isFirst = false;
			return new DataProvider().getPersons();
		}
		/*if(isScale){
			
			return new DataProvider().getPersons(start, end , isScale);
		}*/
		
		return new DataProvider().getPersons( start, end);
	}
}
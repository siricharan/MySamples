package com.test.slider.data;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	//INSTANCE;
	private static List<Person> cache;
	private static List<Person> viewData;
	static Person person;
	public static int start=0;
	public  static int end=40;
	private static int Data_Size=200;
	public static int totalRecords = 0;

	public DataProvider() {			
	}


	public List<Person> getPersons() {
		cache = new ArrayList<Person>();
				for (int i = 0; i < Data_Size; i++) {
					person = new Person("Fname " + i, "LName " + i, "", i+1);
					if(i%2==0){
						person.setGender("male");		
					}else{
						person.setGender("female");
					}
					cache.add(person);
			}
				totalRecords = cache.size();
		return cache;
	}

	public  List<Person> getPersons(int start, int end) {
		if(cache !=null){
			totalRecords = cache.size();
			end = start+Data_Size;
		//	System.out.println("number of records >>> "+totalRecords);
			if(end>Data_Size){
			if(end >= (totalRecords - 10)){
				if(end> totalRecords+Data_Size+10){

					for (int i = totalRecords-1; i <=end ; i++) {
						person = new Person("Fname " + i, "LName " + i, "", i+1);
						if(i%2==0){
							person.setGender("male");		
						}else{
							person.setGender("female");
						}
						cache.add(person);
				}
				
				}else{
				for (int i = totalRecords-1; i <=totalRecords+Data_Size+10 ; i++) {
					person = new Person("Fname " + i, "LName " + i, "", i+1);
					if(i%2==0){
						person.setGender("male");		
					}else{
						person.setGender("female");
					}
					cache.add(person);
			}
			}
			}
		}
		}
		totalRecords = cache.size();
		//System.out.println("number of records after adding >>> "+cache.size());
		return getDataForView(start, end);
	}
	
private List<Person> getDataForView(int start, int end) {
	viewData = new ArrayList<Person>();
	if (start >= 0) {
		for (int i = start; i <= start + Data_Size - 2; i++) {
			person = (Person) cache.get(i);
			viewData.add(person);
		}
	} else {
		for (int i = 0; i <= Data_Size - 2; i++) {
			person = (Person) cache.get(i);
			viewData.add(person);
		}
	}
	return viewData;
}
}

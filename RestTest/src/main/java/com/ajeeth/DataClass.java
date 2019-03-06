package com.ajeeth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement( name ="dataclass")
public class DataClass {
	
	
	
	
	
		String name;
		int value;
		
		public String getName() {
			return name;
		}
		
		@XmlElement 
		public void setName(String name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		
		@XmlElement 
		public void setValue(int value) {
			this.value = value;
		}
	


}

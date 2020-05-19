package readObjectAndNestedObjectFromAJsonFile.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import readObjectAndNestedObjectFromAJsonFile.mySourceFactory.MyJsonPropertySourceFactory;

@Component
@PropertySource(
		  value = "classpath:myConfiguration.json", 
		  factory = MyJsonPropertySourceFactory.class)
@ConfigurationProperties
public class MyConfigurationBean {
	private MyObject myObject;
	private MySecondObject mySecondObject;
	public static class MyObject {
		private String myString1;
		private String myString2;
		public String getMyString1() {
			return myString1;
		}
		public void setMyString1(String myString1) {
			this.myString1 = myString1;
		}
		public String getMyString2() {
			return myString2;
		}
		public void setMyString2(String myString2) {
			this.myString2 = myString2;
		}
	}
	public static class MySecondObject {
		private MyNestedObject myNestedObject;
		public static class MyNestedObject {
			private Integer myInt1;
			private Integer myInt2;
			public Integer getMyInt1() {
				return myInt1;
			}
			public void setMyInt1(Integer myInt1) {
				this.myInt1 = myInt1;
			}
			public Integer getMyInt2() {
				return myInt2;
			}
			public void setMyInt2(Integer myInt2) {
				this.myInt2 = myInt2;
			}
		}
		public MyNestedObject getMyNestedObject() {
			return myNestedObject;
		}
		public void setMyNestedObject(MyNestedObject myNestedObject) {
			this.myNestedObject = myNestedObject;
		}
	}
	public MyObject getMyObject() {
		return myObject;
	}
	public void setMyObject(MyObject myObject) {
		this.myObject = myObject;
	}
	public MySecondObject getMySecondObject() {
		return mySecondObject;
	}
	public void setMySecondObject(MySecondObject mySecondObject) {
		this.mySecondObject = mySecondObject;
	}
}
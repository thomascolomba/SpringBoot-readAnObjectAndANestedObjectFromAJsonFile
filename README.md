How to simple object and nested object from a json configuration file with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readObjectAndNestedObjectFromAJsonFile-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
---myConfiguration.json<br/>
{<br/>
&nbsp;&nbsp;"myObject" : {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"myString1":"qwerty1",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"myString2":"qwerty2"<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;"mySecondObject" : {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"myNestedObject" : {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"myInt1":"123",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"myInt2":"456"<br/>
&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
&nbsp;&nbsp;}<br/>
}<br/>
---MyJsonPropertySourceFactory.java<br/>
Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);<br/>
return new MapPropertySource("json-property", readValue);<br/>
---MyConfigurationBean.java<br/>
@PropertySource(<br/>
&nbsp;&nbsp;value = "classpath:myConfiguration.json", <br/>
&nbsp;&nbsp;factory = MyJsonPropertySourceFactory.class)<br/>
...<br/>
private MyObject myObject;<br/>
&nbsp;&nbsp;private MySecondObject mySecondObject;<br/>
&nbsp;&nbsp;public static class MyObject {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private String myString1;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private String myString2;<br/>
...<br/>
public static class MySecondObject {<br/>
&nbsp;&nbsp;private MyNestedObject myNestedObject;<br/>
&nbsp;&nbsp;public static class MyNestedObject {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private Integer myInt1;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private Integer myInt2;<br/>
+all getters and setters<br/>
---MyObjectConverterUtil.java<br/>
<b>final ObjectMapper mapper = new ObjectMapper();<br/>
return mapper.convertValue(myObjectFromJson, clazz);</b><br/>
---MyMyObjectConverter.java and MyMySecondObjectConverter.java<br/>
public MyObject/MySecondObject convert(LinkedHashMap<String, String> sourceFromJson) {<br/>
return (MyObject/MySecondObject) MyObjectConverterUtil.copyHashMapContentIntoEquivalentMyObject(sourceFromJson, MyObject/MySecondObject.class);<br/>
---The class who displays the value of the 'myString' configuration<br/>
@Autowired<br/>
MyConfigurationBean myConf;<br/>
...<br/>
System.out.println(myConf.getMyObject().getMyString1());<br/>
System.out.println(myConf.getMyObject().getMyString2());<br/>
System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt1());<br/>
System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt2());<br/>
<br/>
<br/>
The application will read the the content of the simple object and the nested one from the configuration file then display them in the terminal.<br/>



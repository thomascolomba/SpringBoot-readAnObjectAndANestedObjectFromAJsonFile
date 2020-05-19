package readObjectAndNestedObjectFromAJsonFile.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyConfigurationDisplayer implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	MyConfigurationBean myConf;
	
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		System.out.println("Will display the object and the nested object from the src/main/resources/myConfiguration.json file");
		System.out.println(myConf.getMyObject().getMyString1());
		System.out.println(myConf.getMyObject().getMyString2());
		System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt1());
		System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt2());
	}
}
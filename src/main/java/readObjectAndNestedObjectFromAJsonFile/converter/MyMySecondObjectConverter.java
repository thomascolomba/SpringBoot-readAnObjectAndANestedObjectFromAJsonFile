package readObjectAndNestedObjectFromAJsonFile.converter;

import java.util.LinkedHashMap;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import readObjectAndNestedObjectFromAJsonFile.configuration.MyConfigurationBean.MySecondObject;

@Component
@ConfigurationPropertiesBinding
public class MyMySecondObjectConverter implements Converter<LinkedHashMap<String, String> , MySecondObject> {
	@Override
    public MySecondObject convert(LinkedHashMap<String, String> sourceFromJson) {
        if (sourceFromJson == null) {
            return null;
        }
        return copyHashMapContentIntoEquivalentMySecondObject(sourceFromJson);
    }
	
	//note : could be merged with similar method in MyMyObjectConverter
    private MySecondObject copyHashMapContentIntoEquivalentMySecondObject(LinkedHashMap<String, String> myObjectFromJson) {
    	final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(myObjectFromJson, MySecondObject.class);
    }
}

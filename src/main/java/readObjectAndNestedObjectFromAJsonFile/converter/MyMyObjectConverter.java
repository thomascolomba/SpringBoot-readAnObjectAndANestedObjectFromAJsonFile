package readObjectAndNestedObjectFromAJsonFile.converter;

import java.util.LinkedHashMap;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import readObjectAndNestedObjectFromAJsonFile.configuration.MyConfigurationBean.MyObject;

@Component
@ConfigurationPropertiesBinding
public class MyMyObjectConverter implements Converter<LinkedHashMap<String, String> , MyObject> {
    @Override
    public MyObject convert(LinkedHashMap<String, String> sourceFromJson) {
        if (sourceFromJson == null) {
            return null;
        }
        return copyHashMapContentIntoEquivalentMyObject(sourceFromJson);
    }
    
    private MyObject copyHashMapContentIntoEquivalentMyObject(LinkedHashMap<String, String> myObjectFromJson) {
    	final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(myObjectFromJson, MyObject.class);
    }
}
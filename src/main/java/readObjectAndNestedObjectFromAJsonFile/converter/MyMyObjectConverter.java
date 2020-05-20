package readObjectAndNestedObjectFromAJsonFile.converter;

import java.util.LinkedHashMap;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import readObjectAndNestedObjectFromAJsonFile.configuration.MyConfigurationBean.MyObject;

@Component
@ConfigurationPropertiesBinding
public class MyMyObjectConverter implements Converter<LinkedHashMap<String, String> , MyObject> {
    @Override
    public MyObject convert(LinkedHashMap<String, String> sourceFromJson) {
        return (MyObject) MyObjectConverterUtil.copyHashMapContentIntoEquivalentMyObject(sourceFromJson, MyObject.class);
    }
}
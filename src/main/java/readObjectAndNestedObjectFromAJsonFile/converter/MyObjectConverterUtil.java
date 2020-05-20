package readObjectAndNestedObjectFromAJsonFile.converter;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyObjectConverterUtil{
    public static Object copyHashMapContentIntoEquivalentMyObject(LinkedHashMap<String, String> myObjectFromJson, java.lang.Class clazz) {
    	if (myObjectFromJson == null) {
            return null;
        }
    	final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(myObjectFromJson, clazz);
    }
}

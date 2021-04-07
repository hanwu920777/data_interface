package com.sumscope.data.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JsonUtil {
    private static final String DEFAULT_DATE_FORMAT = "yyyyMMdd HH:mm:ss.SSS";
    public static final ObjectMapper OBJECT_MAPPER = createObjectMapper();
    private static final Pattern linePattern = Pattern.compile("_(\\w)");


    public static <T> T toObject(String json, Class<T> type) throws JsonProcessingException {
        if (null == json) return null;

        return OBJECT_MAPPER.readValue(json, type);
    }

    /**
     * 把Json字符串转换成对象
     *
     * @param <T>           the type parameter
     * @param json          the json
     * @param typeReference the typeReference
     * @return object
     */
    public static <T> T toObject(String json, TypeReference<T> typeReference) throws JsonProcessingException {
        if (null == json) return null;

        return OBJECT_MAPPER.readValue(json, typeReference);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        if (null == obj) return null;

        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT))
                .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .enable(DeserializationFeature.USE_LONG_FOR_INTS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
//                .setPropertyNamingStrategy(new MyStrategy())
                ;
    }

    public static class MyStrategy extends PropertyNamingStrategy {
        private static final long serialVersionUID = -5272349511626698422L;

        @Override
        public String nameForField(MapperConfig
                                           config,
                                   AnnotatedField field, String defaultName) {
            return humpToLine(defaultName);

        }

        @Override
        public String nameForGetterMethod(MapperConfig
                                                  config,
                                          AnnotatedMethod method, String defaultName) {
            return humpToLine(defaultName);
        }

        @Override
        public String nameForSetterMethod(MapperConfig
                                                  config,
                                          AnnotatedMethod method, String defaultName) {
            return humpToLine(defaultName);
        }

        public String convert(String input) {
            if (input.contains("_")){
                Matcher matcher = linePattern.matcher(input);
                StringBuffer sb = new StringBuffer();
                while (matcher.find()) {
                    matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
                }
                matcher.appendTail(sb);
                return sb.toString();
            }
            return input;
        }

        public String humpToLine(String input){
            if (input.contains("_")){
                return input.replaceAll("[A-Z]", "_$0").toLowerCase();
            }
            return input;

        }

    }

    private JsonUtil() {
    }

    public static void main(String[] args) {
        MyStrategy strategy = new MyStrategy();
        System.out.println(strategy.convert("spring_boot"));
        System.out.println(strategy.convert("springBoot"));
        System.out.println(strategy.convert("spring-boot"));
    }
}

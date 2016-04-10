package us.sunrisemorning.mykancolle.utils;

import com.alibaba.fastjson.serializer.NameFilter;

public class ApiKeyNameFilter implements NameFilter {
    private static final String API_KEY_NAME_PREFIX = "api_";

    @Override
    public String process(Object object, String propertyName, Object propertyValue) {
        StringBuffer sb = new StringBuffer(API_KEY_NAME_PREFIX);
        sb.append(propertyName);
        return sb.toString();
    }

}

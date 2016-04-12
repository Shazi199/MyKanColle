package us.sunrisemorning.mykancolle.utils;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.serializer.NameFilter;

public class ApiKeyNameFilter implements NameFilter {
    private static final String API_KEY_NAME_PREFIX = "api_";

    @Override
    public String process(Object object, String propertyName, Object propertyValue) {
        // 是数字则直接输出
        if (StringUtils.isNumeric(propertyName)) {
            return propertyName;
        }
        StringBuffer sb = new StringBuffer(API_KEY_NAME_PREFIX);
        sb.append(propertyName);
        return sb.toString();
    }

}

package us.sunrisemorning.mykancolle.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jfinal.core.Controller;

import us.sunrisemorning.mykancolle.model.User;

public abstract class ApiController extends Controller {
    private static final ApiKeyNameFilter API_KEY_NAME_FILTER_INSTANCE = new ApiKeyNameFilter();

    public User getCurrentUser() {
        return User.dao.findFirst("select * from user where token=?", getPara("api_token"));
    }
    
    public void renderApiJson(JSONObject data) {
        renderApi(data);
    }
    
    private void renderApi(Object data) {
        Map<Object, Object> resultMap = generateResultMap();
        if (data != null) {
            resultMap.put("data", data);
        }
        String jsonStr = JSON.toJSONString(resultMap, API_KEY_NAME_FILTER_INSTANCE, SerializerFeature.BrowserCompatible);
        renderText("svdata=" + jsonStr);
    }

    private Map<Object, Object> generateResultMap() {
        Map<Object, Object> resultMap = new HashMap<Object, Object>();
        resultMap.put("result", 1);
        resultMap.put("result_msg", "成功");
        return resultMap;
    }
}

package us.sunrisemorning.mykancolle.utils;

import org.json.JSONObject;

import com.jfinal.core.Controller;

public abstract class ApiController extends Controller {
    public void renderApiJson(JSONObject data) {
        JSONObject result = new JSONObject();
        result.put("api_result", 1).put("api_result_msg", "成功");
        if (data != null) {
            result.put("api_data", data);
        }
        renderJson("svdata=" + result.toString());
    }
}

package us.sunrisemorning.mykancolle.gadgets;

import java.util.Date;

import org.json.JSONObject;

import com.jfinal.core.Controller;

import us.sunrisemorning.mykancolle.model.User;

public class GadgetsController extends Controller {
    public static final String PREFIX_STRING = "throw 1; < don't be evil' >";

    public void makeRequest() {
        //TODO: 需要修改数据
        //登录开始
        User user = User.dao.findFirst("select * from user where username=?","test");
        user.newToken();
        user.update();
        //登录结束
        String url = getPara("url");
        if (url.contains("api_world/get_id")) {
            JSONObject svdata = createSvdata();
            svdata.put("api_data", new JSONObject().put("api_world_id", user.getWorld()));
            renderJSON(url, svdata);
        } else if (url.contains("api_auth_member/dmmlogin")) {
            JSONObject svdata = createSvdata();
            svdata.put("api_token", user.getToken()).put("api_starttime", new Date().getTime());
            renderJSON(url, svdata);
        }
    }

    private JSONObject createHeader() {
        JSONObject header = new JSONObject();
        header.put("Server", "Apache").put("X-Powered-By", "PHP/5.3.3").put("Connection", "close").put("Content-Type", "text/plain");
        return header;
    }

    private JSONObject createSvdata() {
        JSONObject svdata = new JSONObject();
        svdata.put("api_result", 1).put("api_result_msg", "成功").put("headers", createHeader());
        return svdata;
    }

    private void renderJSON(String url, JSONObject svdata) {
        JSONObject result = new JSONObject();
        JSONObject content = new JSONObject();
        content.put("rc", "200");
        content.put("body", "svdata=" + svdata.toString());
        result.put(url, content);
        renderJson(PREFIX_STRING + result.toString());
    }
}

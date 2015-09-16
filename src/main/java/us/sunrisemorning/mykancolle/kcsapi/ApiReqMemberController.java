package us.sunrisemorning.mykancolle.kcsapi;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import us.sunrisemorning.mykancolle.model.Incentive;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiReqMemberController extends ApiController {
    /**
     * 登录时获得的奖励提示
     */
    public void get_incentive() {
        List<Incentive> incentives = User.dao.findFirst("select * from user where token=?", getPara("api_token")).getIncentive();

        //TODO:增加奖励实体，然后清除奖励提示
        
        JSONObject data = new JSONObject();
        data.put("api_count", incentives.size());
        JSONArray item = new JSONArray();
        for (int i = 0; i < incentives.size(); i++) {
            Incentive incentive = incentives.get(i);
            item.put(createItem(incentive.getMode(), incentive.getType(), incentive.getItemId(), incentive.getMessage()));
        }
        data.put("api_item", item);
        renderApiJson(data);
    }

    private JSONObject createItem(int mode, int type, int id, String message) {
        JSONObject item = new JSONObject();
        item.put("api_mode", mode).put("api_type", type).put("api_mst_id", id).put("api_getmes", message);
        return item;
    }
}

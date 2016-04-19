package us.sunrisemorning.mykancolle.kcsapi;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import us.sunrisemorning.mykancolle.model.Incentive;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiReqMemberController extends ApiController {
    /**
     * 登录时获得的奖励提示
     */
    public void get_incentive() {
        List<Incentive> lists = Incentive.dao.find("select id,mode,type,mst_id,getmes from Incentive where user=?", getCurrentUser().getId());
        JSONObject data = new JSONObject();
        data.put("count", lists.size());
        if (lists.size() > 0) {
            data.put("item", lists);
            for (Incentive i : lists) {
                i.delete();
            }
        }
        renderApiJson(data);
    }
}

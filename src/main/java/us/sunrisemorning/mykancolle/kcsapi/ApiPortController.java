package us.sunrisemorning.mykancolle.kcsapi;

import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import us.sunrisemorning.mykancolle.model.Basic;
import us.sunrisemorning.mykancolle.model.Deck;
import us.sunrisemorning.mykancolle.model.Log;
import us.sunrisemorning.mykancolle.model.Material;
import us.sunrisemorning.mykancolle.model.Ndock;
import us.sunrisemorning.mykancolle.model.Params;
import us.sunrisemorning.mykancolle.model.Ship;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiPortController extends ApiController {
    public void port() {
        User u = getCurrentUser();

        JSONObject result = new JSONObject();
        result.put("material", getMaterial(u.getId()));
        result.put("deck_port", getDeck(u.getId()));
        result.put("ndock", getNdock(u.getId()));
        result.put("ship", getShip(u.getId()));
        result.put("basic", getBasic(u.getId()));
        result.put("log", getLog(u.getId()));
        
        Params param = Params.dao.findById(u.getId());
        result.put("p_bgm_id", param.getP_bgm_id());
        result.put("parallel_quest_count", param.getParallel_quest_count());

        renderApiJson(result);
    }

    public List<Material> getMaterial(long userId) {
        List<Material> result = Material.dao.find("select * from Material where member_id=?", userId);
        return result;
    }

    public List<Deck> getDeck(long userId) {
        List<Deck> result = Deck.dao.find("select * from Deck where member_id=?", userId);
        return result;
    }

    public List<Ndock> getNdock(long userId) {
        List<Ndock> result = Ndock.dao.find("select * from Ndock where member_id=?", userId);
        return result;
    }

    public List<Ship> getShip(long userId) {
        List<Ship> result = Ship.dao.find("select * from Ship where user=?", userId);
        return result;
    }

    public Basic getBasic(long userId) {
        Basic basic = Basic.dao.findFirst("select * from Basic where member_id=?", userId);
        return basic;
    }

    public List<Log> getLog(long userId) {
        List<Log> result = Log.dao.find("select * from Log where user=? order by id desc limit 5", userId);
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            Log log = result.get(i);
            log.setNo(i);
        }
        return result;
    }
}

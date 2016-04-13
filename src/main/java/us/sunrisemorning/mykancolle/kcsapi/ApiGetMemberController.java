package us.sunrisemorning.mykancolle.kcsapi;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import us.sunrisemorning.mykancolle.config.GameData;
import us.sunrisemorning.mykancolle.model.Furniture;
import us.sunrisemorning.mykancolle.model.Kdock;
import us.sunrisemorning.mykancolle.model.Material;
import us.sunrisemorning.mykancolle.model.Params;
import us.sunrisemorning.mykancolle.model.PresetDeck;
import us.sunrisemorning.mykancolle.model.Slotitem;
import us.sunrisemorning.mykancolle.model.Useitem;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiGetMemberController extends ApiController {
    public void require_info() {
        User u = getCurrentUser();

        JSONObject result = new JSONObject();
        result.put("basic", getBasic(u));
        result.put("slot_item", getSlotitem(u.getId()));
        result.put("unsetslot", getUnsetslot(u.getId()));
        result.put("kdock", getKdock(u.getId()));
        result.put("useitem", getUseitem(u.getId()));
        result.put("furniture", getFurniture(u.getId()));

        renderApiJson(result);
    }

    public void preset_deck() {
        User u = getCurrentUser();

        JSONObject result = new JSONObject();
        Params param = Params.dao.findById(u.getId());
        result.put("max_num", param.getMax_preset_deck());
        result.put("deck", getPresetDeck(u.getId()));

        renderApiJson(result);
    }

    public void kdock() {
        User u = getCurrentUser();

        JSONArray result = new JSONArray();
        result.addAll(getKdock(u.getId()));

        renderApiJson(result);
    }

    public void material() {
        User u = getCurrentUser();

        JSONArray result = new JSONArray();
        result.addAll(getMaterial(u.getId()));

        renderApiJson(result);
    }

    private JSONObject getPresetDeck(long userId) {
        List<PresetDeck> decks = PresetDeck.dao.find("select * from preset_deck where user=? and ship1<>-1 order by preset_no", userId);
        JSONObject result = new JSONObject();
        for (int i = 0; i < decks.size(); i++) {
            PresetDeck deck = decks.get(i);
            result.put(String.valueOf(deck.getPreset_no()), deck);
        }
        return result;
    }

    private JSONObject getBasic(User user) {
        JSONObject basic = new JSONObject();
        basic.put("member_id", user.getId());
        basic.put("firstflag", 1);
        return basic;
    }

    private List<Slotitem> getSlotitem(long userId) {
        List<Slotitem> slotitemList = Slotitem.dao.find("select id,slotitem_id,locked,level,alv from Slotitem where user=?", userId);
        return slotitemList;
    }

    private JSONObject getUnsetslot(long userId) {
        JSONObject result = new JSONObject();

        // TODO: 需要改为未装备的item的查询
        List<Slotitem> slotitemList = Slotitem.dao.find("select id,slotitem_id,locked,level,alv from Slotitem where user=?", userId);
        for (Slotitem item : slotitemList) {
            int category = GameData.getSlotitemData().get(item.getSlotitem_id()).getJSONArray("api_type").getInteger(2);
            JSONArray categoryItems = result.getJSONArray("slottype" + category);
            if (categoryItems == null) {
                categoryItems = new JSONArray();
                result.put("slottype" + category, categoryItems);
            }
            categoryItems.add(item.getId());
        }

        for (int category : GameData.getSlotitemEquiptypeData().keySet()) {
            if (!result.containsKey("slottype" + category)) {
                result.put("slottype" + category, -1);
            }
        }

        return result;
    }

    private List<Kdock> getKdock(long userId) {
        List<Kdock> kdockList = Kdock.dao.find("select id,state,created_ship_id,complete_time,complete_time_str,item1,item2,item3,item4,item5 from Kdock where member_id=?", userId);
        return kdockList;
    }

    private List<Useitem> getUseitem(long userId) {
        List<Useitem> useitemList = Useitem.dao.find("select id,count from Useitem where user=?", userId);
        return useitemList;
    }

    private List<Furniture> getFurniture(long userId) {
        List<Furniture> furnitureList = Furniture.dao.find("select id,furniture_type,furniture_no,furniture_id from Furniture where user=?", userId);
        return furnitureList;
    }

    public List<Material> getMaterial(long userId) {
        List<Material> result = Material.dao.find("select * from Material where member_id=?", userId);
        return result;
    }
}

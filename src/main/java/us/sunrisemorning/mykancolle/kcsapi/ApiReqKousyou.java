package us.sunrisemorning.mykancolle.kcsapi;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.fastjson.JSONObject;

import us.sunrisemorning.mykancolle.config.GameData;
import us.sunrisemorning.mykancolle.model.Deck;
import us.sunrisemorning.mykancolle.model.Kdock;
import us.sunrisemorning.mykancolle.model.Material;
import us.sunrisemorning.mykancolle.model.Ship;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiReqKousyou extends ApiController {
    public void createship() {
        User u = getCurrentUser();

        Long kdock_id = getParaToLong("api_kdock_id");
        Integer highspeed = getParaToInt("api_highspeed");
        Integer large_flag = getParaToInt("api_large_flag");
        Integer item1 = getParaToInt("api_item1");
        Integer item2 = getParaToInt("api_item2");
        Integer item3 = getParaToInt("api_item3");
        Integer item4 = getParaToInt("api_item4");
        Integer item5 = getParaToInt("api_item5");

        int shipId = randomShipId(large_flag == 1);
        JSONObject shipData = GameData.getShipData().get(shipId);

        Kdock dock = Kdock.dao.findById(kdock_id, u.getId());
        dock.setCreated_ship_id(shipId);
        if (highspeed == 1) {
            dock.setState(3);
            dock.setComplete_time(0l);
            dock.setComplete_time_str("0");
        } else {
            dock.setState(2);
            Integer min = shipData.getInteger("api_buildtime");
            long time = new Date().getTime() + min * 60 * 1000;
            String time_str = DateFormatUtils.format(new Date(time), "yyyy-MM-dd HH:mm:ss");
            dock.setComplete_time(time);
            dock.setComplete_time_str(time_str);
        }
        dock.setItem1(item1);
        dock.setItem2(item2);
        dock.setItem3(item3);
        dock.setItem4(item4);
        dock.setItem5(item5);
        dock.update();

        renderApiJson(null);
    }

    public void getship() {
        User u = getCurrentUser();

        Long kdock_id = getParaToLong("api_kdock_id");
        Kdock dock = Kdock.dao.findById(kdock_id, u.getId());
        int shipId = dock.getCreated_ship_id();

        JSONObject result = new JSONObject();
        makeShip(result, shipId, u.getId());
        dock.setState(0);
        dock.setCreated_ship_id(0);
        dock.setComplete_time(0l);
        dock.setComplete_time_str("0");
        dock.setItem1(0);
        dock.setItem2(0);
        dock.setItem3(0);
        dock.setItem4(0);
        dock.setItem5(0);
        dock.update();
        result.put("kdock", getKdock(u.getId()));

        renderApiJson(result);
    }

    public void createship_speedchange() {
        User u = getCurrentUser();

        Long kdock_id = getParaToLong("api_kdock_id");
        Kdock dock = Kdock.dao.findById(kdock_id, u.getId());
        dock.setState(3);
        dock.setComplete_time(0l);
        dock.setComplete_time_str("0");
        dock.update();

        renderApiJson(null);
    }

    public void destroyship() {
        User u = getCurrentUser();

        Long ship_id = getParaToLong("api_ship_id");
        Ship.dao.deleteById(ship_id, u.getId());
        List<Deck> decks = Deck.dao.find("select * from deck where member_id=?", u.getId());
        for (int i = 0; i < decks.size(); i++) {
            Deck deck = decks.get(i);
            int shipIdx = deck.findShipIdxByShipId(ship_id);
            if (shipIdx > 0) {
                deck.removeShipFromDeck(shipIdx);
                deck.update();
            }
        }

        JSONObject result = new JSONObject();
        result.put("material", getMaterial(u.getId()));
        renderApiJson(result);
    }

    private int randomShipId(boolean isLarge) {
        // TODO:需要完成工厂建造的随机算法
        if (isLarge) {
            int[] shipId = new int[] { 131, 143, 153, 442, 441, 171};
            return shipId[RandomUtils.nextInt(0, shipId.length)];
        } else {
            int[] shipId = new int[] { 421, 346, 357, 353, 176, 182, 155};
            return shipId[RandomUtils.nextInt(0, shipId.length)];
        }
    }

    private void makeShip(JSONObject result, int shipId, long userId) {
        Ship ship = Ship.dao.generateShip(shipId, userId);
        ship.save();

        result.put("id", 1);
        result.put("ship_id", shipId);
        result.put("ship", ship);
        result.put("slotitem", null);
    }

    private List<Kdock> getKdock(long userId) {
        List<Kdock> kdockList = Kdock.dao.find("select id,state,created_ship_id,complete_time,complete_time_str,item1,item2,item3,item4,item5 from Kdock where member_id=?", userId);
        return kdockList;
    }

    public Integer[] getMaterial(long userId) {
        List<Material> result = Material.dao.find("select value from Material where member_id=? and id>=1 and id<=4 order by id", userId);
        Integer[] materials = new Integer[4];
        for (int i = 0; i < result.size(); i++) {
            materials[i] = result.get(i).getValue();
        }
        return materials;
    }
}

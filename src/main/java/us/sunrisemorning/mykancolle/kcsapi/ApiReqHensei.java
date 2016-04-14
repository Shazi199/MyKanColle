package us.sunrisemorning.mykancolle.kcsapi;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import us.sunrisemorning.mykancolle.model.Deck;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiReqHensei extends ApiController {
    public void change() {
        User u = getCurrentUser();

        Long deckId = getParaToLong("api_id");
        Integer shipIdx = getParaToInt("api_ship_idx");
        Deck deck = Deck.dao.findById(deckId, u.getId());
        if (shipIdx == -1) {
            int count = 0;
            for (int i = 2; i <= 6; i++) {
                Long shipId = deck.get("ship" + i);
                if (shipId > -1) {
                    deck.set("ship" + i, -1);
                    count++;
                }
            }
            deck.update();
            JSONObject result = new JSONObject();
            result.put("change_count", count);
            renderApiJson(result);
        } else {
            shipIdx = shipIdx + 1;
            Long shipId = getParaToLong("api_ship_id");
            if (shipId == -1) {
                deck.removeShipFromDeck(shipIdx);
            } else {
                // 取目标位置的船ID
                Long targetShipId = deck.getLong("ship" + shipIdx);
                // 取船的原位置
                List<Deck> decks = Deck.dao.find("select * from Deck where member_id=?", u.getId());
                Deck originDeck = null;
                int originIdx = -1;
                for(int i=0;i<decks.size();i++){
                    originIdx = decks.get(i).findShipIdxByShipId(shipId);
                    if(originIdx>0){
                        originDeck = decks.get(i);
                        break;
                    }
                }
                
                if (originDeck != null) {
                    if (targetShipId == -1) {
                        originDeck.removeShipFromDeck(originIdx);
                        originDeck.update();
                    } else {
                        originDeck.set("ship" + originIdx, targetShipId);
                        originDeck.update();
                        if (deck.getId() == originDeck.getId()) {
                            deck = originDeck;
                        }
                    }
                }
                deck.set("ship" + shipIdx, shipId);
            }
            deck.update();
            renderApiJson(null);
        }
    }
}

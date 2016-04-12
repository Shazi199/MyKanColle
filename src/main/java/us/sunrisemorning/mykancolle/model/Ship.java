package us.sunrisemorning.mykancolle.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import us.sunrisemorning.mykancolle.basemodel.BaseShip;
import us.sunrisemorning.mykancolle.config.GameData;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Ship extends BaseShip<Ship> {
    public static final Ship dao = new Ship();

    private JSONObject getShipData(Integer id) {
        return GameData.getShipData().get(id);
    }

    public Integer[] getExp() {
        // TODO:需要完成
        return new Integer[] { getExp_total(), 0, 0 };
    }

    public Integer[] getSlot() {
        return new Integer[] { getSlot1(), getSlot2(), getSlot3(), getSlot4(), getSlot5() };
    }

    public Integer[] getOnslot() {
        return new Integer[] { getOnslot1(), getOnslot2(), getOnslot3(), getOnslot4(), getOnslot5() };
    }

    public Integer[] getKyouka() {
        return new Integer[] { getKyouka1(), getKyouka2(), getKyouka3(), getKyouka4(), getKyouka5() };
    }

    public Integer[] getNdock_item() {
        return new Integer[] { getNdock_item1(), getNdock_item2() };
    }

    public Integer getBacks() {
        return this.getShipData(getShip_id()).getInteger("api_backs");
    }

    public Integer getSrate() {
        // TODO:需要完成
        return 1;
    }
    
    public Integer getLeng() {
        // TODO:需要完成
        return this.getShipData(getShip_id()).getInteger("api_leng");
    }

    public Integer[] getKaryoku() {
        return new Integer[] { getKaryoku1(), this.getShipData(getShip_id()).getJSONArray("api_houg").getInteger(1) };
    }

    public Integer[] getRaisou() {
        return new Integer[] { getRaisou1(), this.getShipData(getShip_id()).getJSONArray("api_raig").getInteger(1) };
    }

    public Integer[] getTaiku() {
        return new Integer[] { getTaiku1(), this.getShipData(getShip_id()).getJSONArray("api_tyku").getInteger(1) };
    }

    public Integer[] getSoukou() {
        return new Integer[] { getSoukou1(), this.getShipData(getShip_id()).getJSONArray("api_souk").getInteger(1) };
    }

    public Integer[] getKaihi() {
        // TODO:需要完成
        return new Integer[] { getKaihi1(), 79 };
    }

    public Integer[] getTaisen() {
        // TODO:需要完成
        return new Integer[] { getTaisen1(), 39 };
    }

    public Integer[] getSakuteki() {
        // TODO:需要完成
        return new Integer[] { getSakuteki1(), 17 };
    }

    public Integer[] getLucky() {
        // TODO:需要完成
        return new Integer[] { getLucky1(), this.getShipData(getShip_id()).getJSONArray("api_luck").getInteger(1) };
    }

    @JSONField(serialize = false)
    @Override
    public Integer getExp_total() {
        return super.getExp_total();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSlot1() {
        return super.getSlot1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSlot2() {
        return super.getSlot2();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSlot3() {
        return super.getSlot3();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSlot4() {
        return super.getSlot4();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSlot5() {
        return super.getSlot5();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getOnslot1() {
        return super.getOnslot1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getOnslot2() {
        return super.getOnslot2();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getOnslot3() {
        return super.getOnslot3();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getOnslot4() {
        return super.getOnslot4();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getOnslot5() {
        return super.getOnslot5();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKyouka1() {
        return super.getKyouka1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKyouka2() {
        return super.getKyouka2();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKyouka3() {
        return super.getKyouka3();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKyouka4() {
        return super.getKyouka4();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKyouka5() {
        return super.getKyouka5();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getNdock_item1() {
        return super.getNdock_item1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getNdock_item2() {
        return super.getNdock_item2();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKaryoku1() {
        return super.getKaryoku1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getRaisou1() {
        return super.getRaisou1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getTaiku1() {
        return super.getTaiku1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSoukou1() {
        return super.getSoukou1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getKaihi1() {
        return super.getKaihi1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getTaisen1() {
        return super.getTaisen1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getSakuteki1() {
        return super.getSakuteki1();
    }

    @JSONField(serialize = false)
    @Override
    public Integer getLucky1() {
        return super.getLucky1();
    }
}
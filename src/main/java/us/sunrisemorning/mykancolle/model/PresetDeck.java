package us.sunrisemorning.mykancolle.model;

import com.alibaba.fastjson.annotation.JSONField;

import us.sunrisemorning.mykancolle.basemodel.BasePresetDeck;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class PresetDeck extends BasePresetDeck<PresetDeck> {
    public static final PresetDeck dao = new PresetDeck();

    public Long[] getShip() {
        return new Long[] { getShip1(), getShip2(), getShip3(), getShip4(), getShip5(), getShip6() };
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip1() {
        return super.getShip1();
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip2() {
        return super.getShip2();
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip3() {
        return super.getShip3();
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip4() {
        return super.getShip4();
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip5() {
        return super.getShip5();
    }

    @JSONField(serialize = false)
    @Override
    public Long getShip6() {
        return super.getShip6();
    }

}

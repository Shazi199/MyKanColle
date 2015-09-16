package us.sunrisemorning.mykancolle.model;

import com.jfinal.plugin.activerecord.Model;

public class ShipInfo extends Model<ShipInfo> {
    public static final ShipInfo dao = new ShipInfo();

    public long getId() {
        return getLong("id");
    }
}

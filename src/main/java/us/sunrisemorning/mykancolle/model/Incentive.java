package us.sunrisemorning.mykancolle.model;

import com.jfinal.plugin.activerecord.Model;

public class Incentive extends Model<Incentive> {
    public static final Incentive dao = new Incentive();

    public int getMode() {
        return getInt("mode");
    }

    public int getType() {
        return getInt("type");
    }

    public int getItemId() {
        return getInt("item_id");
    }

    public String getMessage() {
        return getStr("message");
    }
}

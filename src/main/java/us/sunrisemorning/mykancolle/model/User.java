package us.sunrisemorning.mykancolle.model;

import java.util.List;
import java.util.UUID;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
    public static final User dao = new User();

    public void newToken() {
        set("token", UUID.randomUUID().toString());
    }

    public List<Incentive> getIncentive() {
        return Incentive.dao.find("select * from incentive where userid=?", getLong("id"));
    }

    public String getWorld() {
        return getStr("world");
    }

    public String getToken() {
        return getStr("token");
    }
}

package us.sunrisemorning.mykancolle.model;

import java.util.UUID;

import us.sunrisemorning.mykancolle.basemodel.BaseUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User();
	
    public void newToken() {
        set("token", UUID.randomUUID().toString());
    }

}

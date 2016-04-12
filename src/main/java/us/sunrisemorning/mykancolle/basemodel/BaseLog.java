package us.sunrisemorning.mykancolle.basemodel;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseLog<M extends BaseLog<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setUser(java.lang.Long user) {
		set("user", user);
	}

	public java.lang.Long getUser() {
		return get("user");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setState(java.lang.String state) {
		set("state", state);
	}

	public java.lang.String getState() {
		return get("state");
	}

	public void setMessage(java.lang.String message) {
		set("message", message);
	}

	public java.lang.String getMessage() {
		return get("message");
	}

}

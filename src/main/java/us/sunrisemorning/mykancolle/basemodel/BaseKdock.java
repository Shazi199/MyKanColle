package us.sunrisemorning.mykancolle.basemodel;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseKdock<M extends BaseKdock<M>> extends Model<M> implements IBean {

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

	public void setState(java.lang.Integer state) {
		set("state", state);
	}

	public java.lang.Integer getState() {
		return get("state");
	}

	public void setCreated_ship_id(java.lang.Integer created_ship_id) {
		set("created_ship_id", created_ship_id);
	}

	public java.lang.Integer getCreated_ship_id() {
		return get("created_ship_id");
	}

	public void setComplete_time(java.lang.Integer complete_time) {
		set("complete_time", complete_time);
	}

	public java.lang.Integer getComplete_time() {
		return get("complete_time");
	}

	public void setComplete_time_str(java.lang.String complete_time_str) {
		set("complete_time_str", complete_time_str);
	}

	public java.lang.String getComplete_time_str() {
		return get("complete_time_str");
	}

	public void setItem1(java.lang.Integer item1) {
		set("item1", item1);
	}

	public java.lang.Integer getItem1() {
		return get("item1");
	}

	public void setItem2(java.lang.Integer item2) {
		set("item2", item2);
	}

	public java.lang.Integer getItem2() {
		return get("item2");
	}

	public void setItem3(java.lang.Integer item3) {
		set("item3", item3);
	}

	public java.lang.Integer getItem3() {
		return get("item3");
	}

	public void setItem4(java.lang.Integer item4) {
		set("item4", item4);
	}

	public java.lang.Integer getItem4() {
		return get("item4");
	}

	public void setItem5(java.lang.Integer item5) {
		set("item5", item5);
	}

	public java.lang.Integer getItem5() {
		return get("item5");
	}

}
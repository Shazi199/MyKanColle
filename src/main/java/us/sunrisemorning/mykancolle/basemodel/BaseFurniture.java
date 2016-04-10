package us.sunrisemorning.mykancolle.basemodel;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFurniture<M extends BaseFurniture<M>> extends Model<M> implements IBean {

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

	public void setFurniture_type(java.lang.Integer furniture_type) {
		set("furniture_type", furniture_type);
	}

	public java.lang.Integer getFurniture_type() {
		return get("furniture_type");
	}

	public void setFurniture_no(java.lang.Integer furniture_no) {
		set("furniture_no", furniture_no);
	}

	public java.lang.Integer getFurniture_no() {
		return get("furniture_no");
	}

	public void setFurniture_id(java.lang.Integer furniture_id) {
		set("furniture_id", furniture_id);
	}

	public java.lang.Integer getFurniture_id() {
		return get("furniture_id");
	}

}

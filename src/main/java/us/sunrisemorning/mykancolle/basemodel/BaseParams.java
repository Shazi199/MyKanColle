package us.sunrisemorning.mykancolle.basemodel;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseParams<M extends BaseParams<M>> extends Model<M> implements IBean {

	public void setUser(java.lang.Long user) {
		set("user", user);
	}

	public java.lang.Long getUser() {
		return get("user");
	}

	public void setP_bgm_id(java.lang.Integer p_bgm_id) {
		set("p_bgm_id", p_bgm_id);
	}

	public java.lang.Integer getP_bgm_id() {
		return get("p_bgm_id");
	}

	public void setParallel_quest_count(java.lang.Integer parallel_quest_count) {
		set("parallel_quest_count", parallel_quest_count);
	}

	public java.lang.Integer getParallel_quest_count() {
		return get("parallel_quest_count");
	}

}
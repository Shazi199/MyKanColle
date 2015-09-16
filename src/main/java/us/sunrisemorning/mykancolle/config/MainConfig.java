package us.sunrisemorning.mykancolle.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import us.sunrisemorning.mykancolle.gadgets.GadgetsRoutes;
import us.sunrisemorning.mykancolle.index.IndexRoutes;
import us.sunrisemorning.mykancolle.kcsapi.KcsapiRoutes;
import us.sunrisemorning.mykancolle.kcscontents.KcscontentsRoutes;
import us.sunrisemorning.mykancolle.model.EquipInfo;
import us.sunrisemorning.mykancolle.model.EquipType;
import us.sunrisemorning.mykancolle.model.Furniture;
import us.sunrisemorning.mykancolle.model.Incentive;
import us.sunrisemorning.mykancolle.model.ShipEquipType;
import us.sunrisemorning.mykancolle.model.ShipGraph;
import us.sunrisemorning.mykancolle.model.ShipInfo;
import us.sunrisemorning.mykancolle.model.ShipType;
import us.sunrisemorning.mykancolle.model.User;
import us.sunrisemorning.mykancolle.social.SocialRoutes;

public class MainConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new IndexRoutes());
        me.add(new KcscontentsRoutes());
        me.add(new SocialRoutes());
        me.add(new GadgetsRoutes());
        me.add(new KcsapiRoutes());
    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin cp = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);
        arp.addMapping("user", User.class);
        arp.addMapping("incentive", Incentive.class);
        arp.addMapping("ship_info", ShipInfo.class);
        arp.addMapping("ship_graph", ShipGraph.class);
        arp.addMapping("equip_type", EquipType.class);
        arp.addMapping("ship_type", ShipType.class);
        arp.addMapping("ship_equip_type", ShipEquipType.class);
        arp.addMapping("equip_info", EquipInfo.class);
        arp.addMapping("furniture", Furniture.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {
    }

    @Override
    public void configHandler(Handlers me) {
    }

}

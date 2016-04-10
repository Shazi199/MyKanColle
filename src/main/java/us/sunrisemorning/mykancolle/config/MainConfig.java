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
import us.sunrisemorning.mykancolle.model._MappingKit;
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
        _MappingKit.mapping(arp);
    }

    @Override
    public void configInterceptor(Interceptors me) {
    }

    @Override
    public void configHandler(Handlers me) {
    }

    @Override
    public void afterJFinalStart() {
        GameData.init("start2.json");
    }
}

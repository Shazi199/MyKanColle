package us.sunrisemorning.mykancolle.kcscontents;

import com.jfinal.config.Routes;

public class KcscontentsRoutes extends Routes {

    @Override
    public void config() {
        add("kcscontents/news", NewsController.class);
    }

}

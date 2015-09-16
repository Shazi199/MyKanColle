package us.sunrisemorning.mykancolle.index;

import com.jfinal.config.Routes;

public class IndexRoutes extends Routes {

    @Override
    public void config() {
        add("/", IndexController.class);
    }

}

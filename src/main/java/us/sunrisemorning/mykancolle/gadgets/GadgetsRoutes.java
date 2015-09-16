package us.sunrisemorning.mykancolle.gadgets;

import com.jfinal.config.Routes;

public class GadgetsRoutes extends Routes {

    @Override
    public void config() {
        add("gadgets", GadgetsController.class);
    }

}

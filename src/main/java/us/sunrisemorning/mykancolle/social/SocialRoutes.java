package us.sunrisemorning.mykancolle.social;

import com.jfinal.config.Routes;

public class SocialRoutes extends Routes {

    @Override
    public void config() {
        add("social", SocialController.class);
    }

}

package us.sunrisemorning.mykancolle.social;

import com.jfinal.core.Controller;

public class SocialController extends Controller {
    public void rpc() {
        renderJson("[{\"id\":\"viewer\",\"data\":{\"isOwner\":true,\"isViewer\":true,\"userType\":\"\",\"id\":\"15086600\",\"thumbnailUrl\":\"http:\\/\\/localhost\\/freegame\\/profile\\/m\\/male1\\/male1_mb.gif\",\"displayName\":\"\\u6668\\u66e6\\u7684\\u5fae\\u6dbc\"}}]");
    }
}

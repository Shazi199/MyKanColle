package us.sunrisemorning.mykancolle.kcsapi;

import com.jfinal.config.Routes;

public class KcsapiRoutes extends Routes {

    @Override
    public void config() {
        add("kcsapi/api_start2", ApiStart2Controller.class);
        add("kcsapi/api_req_member", ApiReqMemberController.class);
        add("kcsapi/api_get_member", ApiGetMemberController.class);
        add("kcsapi/api_port", ApiPortController.class);
        add("kcsapi/api_req_kousyou", ApiReqKousyou.class);
        add("kcsapi/api_req_hensei",ApiReqHensei.class);
    }

}

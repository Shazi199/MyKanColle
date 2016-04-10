package us.sunrisemorning.mykancolle.kcsapi;

import us.sunrisemorning.mykancolle.config.GameData;
import us.sunrisemorning.mykancolle.utils.ApiController;

public class ApiStart2Controller extends ApiController {    
    public void index() {
        renderText(GameData.getOutputData());
    }
}

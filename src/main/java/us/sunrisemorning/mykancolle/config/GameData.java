package us.sunrisemorning.mykancolle.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class GameData {
    private static JSONObject data;
    private static Map<Integer, JSONObject> slotitemData;
    private static Map<Integer, JSONObject> slotitemEquiptypeData;
    private static String outputData;

    public static void init(String dataFile) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(dataFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String json = br.readLine();
            data = JSON.parseObject(json);
            initSlotitemData(data);
            initSlotitemEquiptypeData(data);
        } catch (IOException e) {
            data = new JSONObject();
        }
        String jsonStr = JSON.toJSONString(data, SerializerFeature.BrowserCompatible);
        outputData = "svdata=" + jsonStr;
    }
    
    private static void initSlotitemData(JSONObject data) {
        slotitemData = new HashMap<Integer, JSONObject>();
        JSONArray items = data.getJSONObject("api_data").getJSONArray("api_mst_slotitem");
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = items.getJSONObject(i);
            slotitemData.put(item.getInteger("api_id"), item);
        }
    }
    
    private static void initSlotitemEquiptypeData(JSONObject data) {
        slotitemEquiptypeData = new HashMap<Integer, JSONObject>();
        JSONArray items = data.getJSONObject("api_data").getJSONArray("api_mst_slotitem_equiptype");
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = items.getJSONObject(i);
            slotitemEquiptypeData.put(item.getInteger("api_id"), item);
        }
    }

    public static JSONObject getData() {
        return data;
    }

    public static String getOutputData() {
        return outputData;
    }

    public static Map<Integer, JSONObject> getSlotitemData() {
        return slotitemData;
    }

    public static Map<Integer, JSONObject> getSlotitemEquiptypeData() {
        return slotitemEquiptypeData;
    }
}

package us.sunrisemorning.mykancolle.utils;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class ModelGenerator {
    public static void main(String[] args) {
        PropKit.use("config.txt");
        C3p0Plugin cp = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        cp.start();
        Generator g = new Generator(cp.getDataSource(), "us.sunrisemorning.mykancolle.basemodel", "E:\\javaproject\\MyKanColle\\src\\main\\java\\us\\sunrisemorning\\mykancolle\\basemodel", "us.sunrisemorning.mykancolle.model", "E:\\javaproject\\MyKanColle\\src\\main\\java\\us\\sunrisemorning\\mykancolle\\model");
        g.setMetaBuilder(new ModelMetaBuilder(cp.getDataSource()));
        g.generate();
    }
}

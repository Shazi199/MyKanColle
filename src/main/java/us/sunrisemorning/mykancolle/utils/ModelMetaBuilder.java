package us.sunrisemorning.mykancolle.utils;

import javax.sql.DataSource;

import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;

public class ModelMetaBuilder extends MetaBuilder {

    public ModelMetaBuilder(DataSource dataSource) {
        super(dataSource);
    }
    
    @Override
    protected String buildAttrName(String colName) {
        if (dialect instanceof OracleDialect) {
            colName = colName.toLowerCase();
        }
        return colName;
    }
}

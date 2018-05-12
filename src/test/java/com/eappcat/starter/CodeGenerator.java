package com.eappcat.starter;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static final String DB_URL="jdbc:mysql://host:port/test?characterEncoding=UTF8&useSSL=false";
    public static final String DB_USERNAME="root";
    public static final String DB_PASSWORD="";
    public static final String PACKAGE_NAME = "com.eappcat.starter";
    public static void main(String[] args) throws Exception {
        generateCode(args);
    }
    public static void generateCode(String ... tables) {

        if (tables!=null && tables.length>0) {
            boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
            generateByTables(serviceNameStartWithI, PACKAGE_NAME, tables);
        }
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        File file=new File("src/main/java");
        GlobalConfig config = new GlobalConfig();
        String dbUrl = DB_URL;
        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(DB_USERNAME)
                .setPassword(DB_PASSWORD)
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setTablePrefix("tbl_")
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("com.eappcat.starter.entity.BaseEntity")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("Xuan Yue Bo")
                .setOutputDir(file.getAbsolutePath())
                .setFileOverride(false)//关闭文件覆盖
                .setOpen(false);//关闭打开
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        InjectionConfig cfg = new InjectionConfig(){
            @Override
            public void initMap() {

            }
        };

        List<FileOutConfig> focList = new ArrayList();

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);

        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity").setService("service")
                ).setCfg(cfg).setTemplate(tc).execute();
    }
}

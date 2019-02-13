package com.example.demo1.config;

import com.example.demo1.core.ProjectConstant;
import com.example.demo1.utils.PropertyUtil;
import com.example.demo1.utils.SysCode;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {	
	
	private static String jdbcType = PropertyUtil.getProperty("spring.jdbc.type");
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration globlaConfiguration(){
		return new org.apache.ibatis.session.Configuration();
	}

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource,org.apache.ibatis.session.Configuration config) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);
        config.setJdbcTypeForNull(JdbcType.NULL);//解决使用bean传值，当传入值为Null时，提示“无效的列类型”的解决办法
        factory.setConfiguration(config);
        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        factory.setConfiguration(config);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        if(StringUtils.equalsIgnoreCase(jdbcType, SysCode.JDBC_TYPE.ORACLE)){
        	//oracle数据库
            factory.setMapperLocations(resolver.getResources("classpath:mapper/oracle/*.xml"));
        }else{
        	factory.setMapperLocations(resolver.getResources("classpath:mapper/mysql/*.xml"));
        }
        return factory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        if(StringUtils.equalsIgnoreCase(jdbcType, SysCode.JDBC_TYPE.ORACLE)){
        	 properties.setProperty("IDENTITY", "select sys_guid() from dual");
        }else{
        	 properties.setProperty("IDENTITY", "SELECT REPLACE(UUID(),''-'','''')");
    	 }     
        // 主键UUID回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)
        properties.setProperty("ORDER", "BEFORE");
       
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

}


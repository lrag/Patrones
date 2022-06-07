package com.curso.persistencia.datasource;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {

	private static DataSource dataSource;
	
	public static synchronized DataSource getDataSource() {
		//Lazy inicialization
		if(dataSource == null) {			
		    HikariConfig config = new HikariConfig();
	        config.setJdbcUrl("jdbc:h2:file:c:/h2/bbdd_ejemplo_proxy");
	        config.setUsername("sa");
	        config.setPassword("");
	        config.addDataSourceProperty("cachePrepStmts" , "true");
	        config.addDataSourceProperty("prepStmtCacheSize" , "250");
	        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
		    dataSource = new HikariDataSource(config);
		}
		return dataSource;		
	}
	
	private DataSourceUtil() {		
	}
	
}

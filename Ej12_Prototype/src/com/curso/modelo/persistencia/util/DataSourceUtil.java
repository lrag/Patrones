package com.curso.modelo.persistencia.util;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {

	private static DataSource dataSource;
	
	public static synchronized DataSource getDataSource() {
		//Lazy inicialization
		if(dataSource == null) {			
		    HikariConfig config = new HikariConfig();
	        config.setJdbcUrl("jdbc:h2:file:c:/h2/bbdd_pruebas;DB_CLOSE_DELAY=-1");
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

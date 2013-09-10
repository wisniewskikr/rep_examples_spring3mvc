package pl.kwi.db.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

public class DbUnitUtil {
	
	/**
	 * Method fills data base with data from data file with specified path.
	 * 
	 * @param path object <code>String</code> with path to data file
	 * @param sessionFactory object <code>SessionFactory</code> with data base informations
	 */
	public static void executeDataFile(String path, SessionFactory sessionFactory) {

		try {
			
			Connection conn = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
			IDatabaseConnection iDbConn = new DatabaseConnection(conn);
			
			FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().
					build(DbUnitUtil.class.getResourceAsStream(path));

			
			DatabaseOperation.CLEAN_INSERT.execute(iDbConn, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Method fills data base with data from data file with specified path.
	 * 
	 * @param path object <code>String</code> with path to file with data
	 * @param driverClassName object <code>String</code> with driver class name
	 * @param url object <code>String</code> with url to data base
	 * @param user object <code>String</code> with data base user
	 * @param password object <code>String</code> with data base password
	 */
	public static void executeDataFile(String path, String driverClassName, String url, String user, String password) {

		try {
			
			Class.forName(driverClassName);
			Connection conn = DriverManager.getConnection(url, user, password);	
			IDatabaseConnection iDbConn = new DatabaseConnection(conn);
			
			FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().
					build(DbUnitUtil.class.getResourceAsStream(path));

			
			DatabaseOperation.CLEAN_INSERT.execute(iDbConn, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Method clears table from data.
	 * 
	 * @param path object <code>String</code> with path to file with data
	 * @param driverClassName object <code>String</code> with driver class name
	 * @param url object <code>String</code> with url to data base
	 * @param user object <code>String</code> with data base user
	 * @param password object <code>String</code> with data base password
	 */
	public static void clearDataFile(String path, String driverClassName, String url, String user, String password) {

		try {
			
			Class.forName(driverClassName);
			Connection conn = DriverManager.getConnection(url, user, password);	
			IDatabaseConnection iDbConn = new DatabaseConnection(conn);
			
			FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().
					build(DbUnitUtil.class.getResourceAsStream(path));
			
			DatabaseOperation.DELETE.execute(iDbConn, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}

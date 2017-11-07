package util;

import java.lang.reflect.Field;
import java.sql.SQLException;

import control.dao.ConexaoJDBC;

public class CriaTabelasModel {

	public <T> void criarTabela(T t, String primaryKey, String tableName) {
		StringBuilder sql = new StringBuilder();
		Field[] fields = t.getClass().getDeclaredFields();
		sql.append("CREATE TABLE IF NOT EXISTS " + tableName + " (\n");
		for (Field field : fields) {

			if (field.getType().getSimpleName().contains("String")) {
				sql.append(field.getName() + " VARCHAR(255),\n");
			} else if (field.getType().getSimpleName().contains("Integer")) {
				if (field.getName().equals(primaryKey)) {
					sql.append(field.getName() + " INT(255) NOT NULL AUTO_INCREMENT,\n");
				} else {
					sql.append(field.getName() + " INT(255) DEFAULT NULL,\n");
				}
			}
		}
		sql.append("PRIMARY KEY (" + primaryKey + ")\n );");
		System.out.println(sql);
		ConexaoJDBC conexaoJdbc = new ConexaoJDBC();
		try {
			conexaoJdbc.ps(sql.toString()).executeLargeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
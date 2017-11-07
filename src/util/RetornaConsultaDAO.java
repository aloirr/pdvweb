package util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RetornaConsultaDAO {

	@SuppressWarnings("unchecked")
	public static <T> HashSet<T> run(ResultSet rs, T t) {
		HashSet<T> retornoConsulta = new HashSet<>();
		String value = null;
		String colName = null;
		try {
			while (rs.next()) {
				Object obj = t.getClass().newInstance();
				for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
					value = rs.getString(col);
					colName = rs.getMetaData().getColumnName(col);
					try {
						Field field = obj.getClass().getDeclaredField(colName);
						field.setAccessible(true);
						if (rs.getMetaData().getColumnTypeName(col).equals("INT")) {
							if (!value.isEmpty())
								field.set(obj, Integer.parseInt(value));
						} else if (field.getType().getSimpleName().equalsIgnoreCase("List")) {
							List<String> valueList = new ArrayList<>();
							for (String values : value.split(",")) {
								valueList.add(values);
							}

							field.set(obj, valueList);
						} else {
							field.set(obj, value);
						}
						field.setAccessible(false);

					} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
						e.printStackTrace();
					}
				}
				retornoConsulta.add((T) obj);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return retornoConsulta;
	}

}

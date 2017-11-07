package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FuncoesAuxiliaresDAO {

	static public <T> String criaSqlUpdate(T t, String table) {
		String getCampoWhere = "";
		List<String> camposUpdate = new ArrayList<>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getName().equalsIgnoreCase("id")) {
					field.setAccessible(true);
					getCampoWhere = "'" + field.get(t) + "'";
					field.setAccessible(false);
				}
				if (field.getType().getSimpleName().equalsIgnoreCase("List")) {
					field.setAccessible(true);
					camposUpdate
							.add(field.getName()
									+ "=" + "'" + ((List<?>) field.get(t)).stream()
											.map(p -> p.toString()).collect(Collectors.joining(","))
									+ "'");
					field.setAccessible(false);
				} else {
					field.setAccessible(true);
					camposUpdate.add(field.getName() + "=" + "'" + field.get(t) + "'");
					field.setAccessible(false);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {

				e.printStackTrace();
			}

		}
		return "UPDATE " + table + " SET "
				+ camposUpdate.stream().map(p -> p.toString()).collect(Collectors.joining(","))
				+ " WHERE id" + "=" + getCampoWhere;
	}

	static public <T> List<String> retornaAtributosObjetoLista(T t, String campoRemove) {

		List<String> atribObjList = Arrays.asList(t.getClass().getDeclaredFields()).stream()
				.map(Field::getName).sorted().collect(Collectors.toList());
		if (!campoRemove.isEmpty()) {
			atribObjList.remove(campoRemove);
		}
		return atribObjList;
	}

	static public <T> List<String> retornaAtributosObjetoLista(T t) {

		List<String> atribObjList = Arrays.asList(t.getClass().getDeclaredFields()).stream()
				.map(Field::getName).sorted().collect(Collectors.toList());
		return atribObjList;
	}

	static public <T> String retornaAtributosObjetoString(T t, String campoRemove) {
		List<String> lista = retornaAtributosObjetoLista(t, campoRemove);
		String atributosString =
				lista.stream().map(Object::toString).sorted().collect(Collectors.joining(","));
		// StringBuilder atribObjString =
		// Arrays.asList(t.getClass().getDeclaredFields()).stream().map(Field::getName)
		// .collect(Collectors.joining(","));
		// if (!campoRemove.isEmpty()) {
		// atribObjString.replace(campoRemove, "");
		return atributosString;
	}

	static public <T> String retornaAtributosObjetoString(T t) {
		String atributosString = retornaAtributosObjetoLista(t).stream().map(Object::toString)
				.collect(Collectors.joining(","));
		return atributosString;
	}

	static public <T> List<String> retornaValoresObjeto(T t) {
		List<String> campoValue = new ArrayList<>();
		try {
			Field fieldTmp;
			for (String field : retornaAtributosObjetoLista(t)) {
				fieldTmp = t.getClass().getDeclaredField(field);
				fieldTmp.setAccessible(true);
				campoValue.add("'" + fieldTmp.get(t) + "'");
				fieldTmp.setAccessible(false);
			}
			return campoValue;
		} catch (IllegalArgumentException | NoSuchFieldException | SecurityException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static public <T> List<String> retornaValoresObjeto(T t, String campoRemove) {
		List<String> campoValue = new ArrayList<>();
		try {
			Field fieldTmp;
			for (String field : retornaAtributosObjetoLista(t)) {
				if (!field.equals(campoRemove)) {
					fieldTmp = t.getClass().getDeclaredField(field);
					System.out.println(fieldTmp);

					fieldTmp.setAccessible(true);
					System.out.println(fieldTmp.get(t));
					campoValue.add("'" + fieldTmp.get(t) + "'");
					fieldTmp.setAccessible(false);
				}
			}
			return campoValue;
		} catch (IllegalArgumentException | NoSuchFieldException | SecurityException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}

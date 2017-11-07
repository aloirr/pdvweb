package interfaces;

import java.util.HashSet;

public interface IcontratoRules<T> {

	public String insert(T t);

	public String update(T t);

	public HashSet<T> searchBy(T t, String atributoWhere, String stringPequisa);

	public HashSet<T> findInSet(T t, String atributoWhere, String stringPequisa);

	public String delete(String id);

	public HashSet<T> readTable(T t);

	public Integer count(String atributoWhere, String stringPequisa);

	public Integer countTable();
}

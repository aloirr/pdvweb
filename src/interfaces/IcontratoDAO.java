package interfaces;

import java.util.HashSet;

public interface IcontratoDAO<T> {

	public Integer insert(T t);

	public HashSet<T> searchBy(T t, String atributoWhere, String string);

	public HashSet<T> readTable(T t);

	public HashSet<T> findInSet(T t, String atributoWhere, String stringPequisa);

	public Long update(T t);

	public Long delete(String id);

	public Integer countTable();

	public Integer count(String atributoWhere, String string);
}

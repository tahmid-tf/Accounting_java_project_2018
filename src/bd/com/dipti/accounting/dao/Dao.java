
package bd.com.dipti.accounting.dao;

import java.util.List;


public interface Dao <T>{
    
    public void save(T value);
    public void update(T value);
    public void delete(T value);
    public T find(T value);
    public List<T> getAll();
}

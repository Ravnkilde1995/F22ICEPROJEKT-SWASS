package system;
import java.util.ArrayList;

public interface Repo <T> {

    void read(T t, int id);

    void create (T t);

    void update (T t, int id);

    void delete (int id);
}

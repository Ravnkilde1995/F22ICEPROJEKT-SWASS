package system;
import java.util.ArrayList;

public interface Repo <T> {


    ArrayList<T> readAll();

    void create (T t);

    void update (String username, int balance);

    void delete (int id);
}

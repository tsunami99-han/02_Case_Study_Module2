package management;
import java.util.List;

public interface GeneralManagement<T> {
    void display();

    T findById(int id);

    void add();

    void edit(int id);

    void delete(int id);

}
import java.util.ArrayList;
public interface Repository {

    void save(Task task);

    Task findById(String id);

    ArrayList<Task> findAll();

    void deleteById(String id);
}

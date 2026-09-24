import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;
public class Db implements Repository{
  private HashMap<String, Task> tasks = new HashMap<>();

  @Override
    public void save(Task task){
      tasks.put(task.getId(), task);
  }

  @Override
  public Task findById(String id){
      return tasks.get(id);
    }

  @Override
  public void deleteById(String id){
      tasks.remove(id);
  }

  @Override
    public ArrayList<Task> findAll(){
      return new ArrayList<>(tasks.values());
  }


}

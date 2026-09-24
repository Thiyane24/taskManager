public class Service {
private final Repository Repository;


    public Service (Repository repository){
        this.Repository = repository;
    }

    public void createNewTask(String id, String title){
        Task task = new Task(id, title, "TODO");
        Repository.save(task);
        System.out.println("Task created successfully: "+ title);
    }

    public void updateTaskStatus(String id, String newStatus){
        Task foundTask = Repository.findById(id);

        if(foundTask == null){
            throw new IllegalArgumentException("Error: Task with ID " + id + " does not exist.");
        }
        foundTask.setStatus(newStatus);
        Repository.save(foundTask);
        System.out.println("Task " + id + " updated to: " + newStatus);
    }
}

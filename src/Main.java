import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository database = new Db();
        Service jiraService = new Service(database);

        Scanner scanner = new Scanner(System.in);
        boolean appRunning = true;

        System.out.println("=== Welcome to Interactive Mini-Jira ===");

        while (appRunning) {
            System.out.println("\nMenu: [1] Create Task  [2] Update Status  [3] View All  [4] Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter a new Task ID (e.g., T1): ");
                    String newId = scanner.nextLine();

                    System.out.print("Enter the Task Title: ");
                    String newTitle = scanner.nextLine();

                    jiraService.createNewTask(newId, newTitle);
                    break;

                case "2":
                    System.out.print("Enter the Task ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter new Status (TODO, IN_PROGRESS, DONE): ");
                    String newStatus = scanner.nextLine();

                    try {
                        jiraService.updateTaskStatus(updateId, newStatus);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Action Aborted: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("\n--- CURRENT DATABASE STATE ---");
                    for (Task task : database.findAll()) {
                        System.out.println("ID: " + task.getId() + " | Title: " + task.getTitle() + " | Status: " + task.getStatus());
                    }
                    break;

                case "4":
                    appRunning = false;
                    System.out.println("Exiting Mini-Jira. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please type 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}
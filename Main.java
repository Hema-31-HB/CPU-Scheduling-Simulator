import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===============================");
            System.out.println("CPU Scheduling Simulator");
            System.out.println("===============================");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. Priority Scheduling");
            System.out.println("4. Round Robin");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank You!");
                break;
            }

            ArrayList<Process> processes = new ArrayList<>();

            System.out.print("\nEnter Number of Processes: ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nProcess " + i);

                System.out.print("Arrival Time : ");
                int at = sc.nextInt();

                System.out.print("Burst Time : ");
                int bt = sc.nextInt();

                System.out.print("Priority : ");
                int pr = sc.nextInt();

                processes.add(new Process(i, at, bt, pr));
            }

            switch (choice) {

                case 1:
                    FCFS.calculate(processes);
                    break;

                case 2:
                    SJF.calculate(processes);
                    break;

                case 3:
                    PriorityScheduling.calculate(processes);
                    break;

                case 4:

                    System.out.print("Enter Time Quantum: ");
                    int q = sc.nextInt();

                    RoundRobin.calculate(processes, q);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}
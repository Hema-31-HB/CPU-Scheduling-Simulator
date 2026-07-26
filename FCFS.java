import java.util.*;

public class FCFS {

    public static void calculate(ArrayList<Process> p) {

        p.get(0).waitingTime = 0;

        for (int i = 1; i < p.size(); i++) {

            p.get(i).waitingTime =
                    p.get(i - 1).waitingTime +
                    p.get(i - 1).burstTime;
        }

        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n===== FCFS Scheduling =====");
        System.out.println("PID\tBT\tWT\tTAT");

        for (Process x : p) {

            x.turnaroundTime =
                    x.waitingTime + x.burstTime;

            totalWT += x.waitingTime;
            totalTAT += x.turnaroundTime;

            System.out.println(
                    x.pid + "\t" +
                    x.burstTime + "\t" +
                    x.waitingTime + "\t" +
                    x.turnaroundTime
            );
        }

        System.out.printf("\nAverage Waiting Time : %.2f\n",
                totalWT / p.size());

        System.out.printf("Average Turnaround Time : %.2f\n",
                totalTAT / p.size());

        System.out.println("\nGantt Chart");

        int time = 0;

        for (Process x : p)
            System.out.print("| P" + x.pid + " ");

        System.out.println("|");

        System.out.print("0");

        for (Process x : p) {

            time += x.burstTime;
            System.out.print("    " + time);
        }

        System.out.println();
    }
}
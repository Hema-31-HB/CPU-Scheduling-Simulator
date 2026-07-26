import java.util.*;

public class RoundRobin {

    public static void calculate(ArrayList<Process> p, int quantum) {

        int n = p.size();

        int[] remaining = new int[n];

        for (int i = 0; i < n; i++)
            remaining[i] = p.get(i).burstTime;

        int time = 0;

        boolean done;

        do {

            done = true;

            for (int i = 0; i < n; i++) {

                if (remaining[i] > 0) {

                    done = false;

                    if (remaining[i] > quantum) {

                        time += quantum;

                        remaining[i] -= quantum;

                    } else {

                        time += remaining[i];

                        p.get(i).turnaroundTime = time;

                        p.get(i).waitingTime =
                                time -
                                p.get(i).burstTime;

                        remaining[i] = 0;
                    }
                }
            }

        } while (!done);

        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n===== Round Robin =====");
        System.out.println("PID\tWT\tTAT");

        for (Process x : p) {

            totalWT += x.waitingTime;
            totalTAT += x.turnaroundTime;

            System.out.println(
                    x.pid + "\t" +
                    x.waitingTime + "\t" +
                    x.turnaroundTime
            );
        }

        System.out.printf("\nAverage Waiting Time : %.2f\n",
                totalWT / n);

        System.out.printf("Average Turnaround Time : %.2f\n",
                totalTAT / n);
    }
}
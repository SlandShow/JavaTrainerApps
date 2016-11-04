package ProjectEulerTasks.mult_3_5;


public class Problem2Task {


    public static int PrimeNumber(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return -1;

            if ((i == number) || (i > Math.sqrt(number))) return 1;
        }

        return 1;
    }

    public static int PrimeNumberSlower(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return -1;

            if ((i == number)) return 1;
        }

        return 1;
    }

}

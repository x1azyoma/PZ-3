package task7;

class Main {

    public static void main(String[] args) {
        printResults(2, 1);   // ln(2)
        printResults(2, 2);   // ln(2)
        printResults(2, 5);   // сума
        printResults(-1, 2);  // помилка (t <= 0)
        printResults(3, -1);  // помилка (i <= 0)
    }

    public static double x(double t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Invalid i = " + i + ". Must be i > 0.");
        }
        if ((i == 1 || i == 2) && t <= 0) {
            throw new IllegalArgumentException("Invalid t = " + t + ". Must be t > 0 for ln(t).");
        }

        if (i == 1 || i == 2) {
            return Math.log(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
    }

    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(x(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}


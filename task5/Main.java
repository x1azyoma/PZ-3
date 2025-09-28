package task5;
 //Задача №5
class Main {

    public static void main(String[] args) {
        printResults(2, 5);   // нормальний випадок
        printResults(10, 34); // нормальний випадок
        printResults(10, 35); // помилка (k >= 35)
        printResults(-5, 10); // помилка (s <= 0)
    }

    public static double calcSeries(double s, int k) {
        if (k >= 35 || k <= 0) {
            throw new IllegalArgumentException("Invalid k = " + k + ". Must be 0 < k < 35.");
        }
        if (s <= 0) {
            throw new IllegalArgumentException("Invalid s = " + s + ". Must be s > 0.");
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            double value = Math.sqrt(s * (1.0 / (i * i)));
            sum += Math.log10(value);
        }
        return sum;
    }

    static void printResults(double s, int k) {
        System.out.print("s:" + s + " k:" + k + " result:");
        try {
            System.out.println(calcSeries(s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}

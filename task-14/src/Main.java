class Main {

    public static void main(String[] args) {
        printResults(1e-3);   // точність 0.001
        printResults(1e-6);   // точність 0.000001
        printResults(0);      // помилка
        printResults(-0.5);   // помилка
    }

    public static double infiniteSum(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("Invalid eps = " + eps + ". Must be eps > 0.");
        }

        double sum = 0.0;
        double term;
        int i = 0;

        do {
            term = Math.pow(-2, i) / (factorial(i) * (i + 1));
            sum += term;
            i++;
        } while (Math.abs(term) >= eps);

        return sum;
    }

    private static double factorial(int n) {
        double fact = 1.0;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(infiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}

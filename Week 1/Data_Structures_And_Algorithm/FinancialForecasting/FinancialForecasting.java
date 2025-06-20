import java.util.Scanner;

public class FinancialForecasting {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total months: ");
        int numberOfMonths = input.nextInt();

        double[] monthlyRevenues = new double[numberOfMonths];

        for (int i = 0; i < numberOfMonths; i++) {
            System.out.print("Revenue for month " + (i + 1) + ": ");
            monthlyRevenues[i] = input.nextDouble();
        }

        double overallRevenue = 0;
        double peakRevenue = monthlyRevenues[0];
        double lowestRevenue = monthlyRevenues[0];

        for (double revenue : monthlyRevenues) {
            overallRevenue += revenue;

            if (revenue > peakRevenue) {
                peakRevenue = revenue;
            }

            if (revenue < lowestRevenue) {
                lowestRevenue = revenue;
            }
        }

        double averageRevenue = overallRevenue / numberOfMonths;

        System.out.println("\n===== Financial Summary =====");
        System.out.printf("Total Revenue: ₹%.2f%n", overallRevenue);
        System.out.printf("Average Monthly Revenue: ₹%.2f%n", averageRevenue);
        System.out.printf("Highest Revenue: ₹%.2f%n", peakRevenue);
        System.out.printf("Lowest Revenue: ₹%.2f%n", lowestRevenue);

        input.close();
    }
}

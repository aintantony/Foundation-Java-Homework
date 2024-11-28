import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        enum DAY {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
            SATURDAY, SUNDAY
        }
        do {
            System.out.println("1. Wage Calculator");
            System.out.println("2. Money Exchange Program");
            System.out.println("5. Exit ");

            System.out.println("Choose (1 - 5) : ");
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    float hour;
                    float wage;
                    String day;
                    float result;
                    DAY enumDay;
                    System.out.println("--------------<<<Wage Calculator>>>-------------");
                    System.out.println("Enter hour(hrs): ");
                    hour = scanner.nextFloat();
                    System.out.println("Enter wage($): ");
                    wage = scanner.nextFloat();
                    System.out.println("Enter day (ex. MONDAY,...,SUNDAY): ");
                    day = scanner.next().toUpperCase();
                    result = wage * hour;
                    // convert normal string to enum
                    enumDay = DAY.valueOf(day);
                    float finalResult = switch (enumDay) {
                        case DAY.SATURDAY, DAY.SUNDAY -> result * 2;
                        default -> result;
                    };

                    System.out.println("=======================");
                    System.out.println("Hour is : " + hour + (hour <= 1 ? "hr" : "hrs"));
                    System.out.println("Wage is : " + wage + "$/1hr");
                    System.out.println("Day of work : " + day);
                    System.out.println("Result is : " + finalResult);
                    System.out.println("=======================");

                }
                break;
                case 2:
                    System.out.println("--------------<<<Money Exchange Program>>>-------------");
                    System.out.println("1. KHR -> USD");
                    System.out.println("2. USD -> KHR");
                    System.out.println("Choose (1 - 2) : ");
                    int choice = scanner.nextInt();
                    final double rate = 4100;
                    float amount;
                    switch (choice) {
                        case 1:
                            System.out.println("Enter amount in KHR: ");
                            amount = scanner.nextFloat();
                            System.out.println("Amount in USD: " + amount / rate);
                            break;
                        case 2:
                            System.out.println("Enter amount in USD: ");
                            amount = scanner.nextFloat();
                            System.out.println("Amount in KHR: " + amount * rate);
                            break;
                        default:
                            System.out.println("Invalid option!! Try again!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid option!! Try again!");
                    break;
            }
        } while (option != 5);
    }
}

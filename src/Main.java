import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String sign = findTheSign(input);
        String[] operands = input.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть два операнда");
        int num1 = Integer.parseInt(operands[0]);
        int num2 = Integer.parseInt(operands[1]);
        if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int result = calculation(num1, num2, sign);

        return String.valueOf(result);
    }

    static String findTheSign(String input) throws Exception {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else throw new Exception("Неверный знак");
    }

    static int calculation(int a, int b, String sign) {

        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

}

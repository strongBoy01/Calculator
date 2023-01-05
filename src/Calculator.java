import java.util.Scanner;

public class Calculator {
    public static String[] values = new String[3];

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int i = 0;
        for(String s : value.split(" ")){
            i++;
        }
        if(i != 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
        values = value.split(" ");
        if (((values[0].contains("1") || values[0].contains("2") || values[0].contains("3")
                || values[0].contains("4") || values[0].contains("5") || values[0].contains("6")
                || values[0].contains("7") || values[0].contains("8") || values[0].contains("9")
                || values[0].contains("10")) && (values[2].contains("I") || values[2].contains("V")
                || values[2].contains("X")))
                ||
                ((values[2].contains("1") || values[2].contains("2") || values[2].contains("3")
                        || values[2].contains("4") || values[2].contains("5") || values[2].contains("6")
                        || values[2].contains("7") || values[2].contains("8") || values[2].contains("9")
                        || values[2].contains("10")) && (values[0].contains("I") || values[0].contains("V")
                        || values[0].contains("X")))){
            throw new Exception("Используются одновременно разные системы счисления");
        }else if ((values[0].contains("1") || values[0].contains("2") || values[0].contains("3")
                || values[0].contains("4") || values[0].contains("5") || values[0].contains("6")
                || values[0].contains("7") || values[0].contains("8") || values[0].contains("9")
                || values[0].contains("10")) &&
                (values[0].contains("1") || values[0].contains("2") || values[0].contains("3")
                        || values[0].contains("4") || values[0].contains("5") || values[0].contains("6")
                        || values[0].contains("7") || values[0].contains("8") || values[0].contains("9")
                        || values[0].contains("10"))) {
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[2]);
            if((a < 1 || a > 10) || (b < 1 || b > 10)) {
                throw new Exception();
            }
            System.out.println(operation(a, b, values[1]));
        }else if((values[0].contains("I") || values[0].contains("V") || values[0].contains("X")) &&
                (values[2].contains("I") || values[2].contains("V") || values[2].contains("X"))) {
            int a = returnInt(values[0]);
            int b = returnInt(values[2]);
            int result = operation(a, b, values[1]);
            romaPrint(result);
        }
    }

    public static int operation(int a, int b, String c){
        if(c.equals("*")) {
            return a * b;
        }else if(c.equals("/")) {
            return a / b;
        }else if(c.equals("+")) {
            return a + b;
        }else if(c.equals("-")) {
            return a - b;
        }else {
            return 0;
        }
    }

    public static int returnInt(String s) throws Exception {
        if(s.contains("I") || s.contains("V") || s.contains("X")) {
            if(s.equals("I")) return 1;
            else if(s.equals("II")) return 2;
            else if(s.equals("III")) return 3;
            else if(s.equals("IV")) return 4;
            else if(s.equals("V")) return 5;
            else if(s.equals("VI")) return 6;
            else if(s.equals("VII")) return 7;
            else if(s.equals("VIII")) return 8;
            else if(s.equals("IX")) return 9;
            else if(s.equals("X")) return 10;
            else throw new Exception();
        }
        return 0;
    }

    public static void romaPrint(int value) throws Exception {
        String result = "";
        if(value < 1){
            throw new Exception("В римской системе нет отрицательных чисел");
        }
        int a = value / 10;
        int b = value % 10;
        // Проверяем на десятки
        if(a >= 1 && a <= 3){
            for(int i = 0; i < a; i++){
                result += "X";
            }
        }else if(a == 4) {
            result += "XL";
        }else if(a == 5) {
            result += "L";
        }else if(a > 5 && a <=8) {
            result += "L";
            for(int i = 0; i < a - 5; i++){
                result += "X";
            }
        }else if(a == 9) {
            result += "XC";
        }else if(a == 10) {
            result += "C";
        }else{
            result = "";
        }

        //Проверяем на еденицы
        if(b >= 1 && b <=3){
            for(int i = 0; i < b; i++){
                result += "I";
            }
        }else if(b == 4) {
            result += "IV";
        }else if (b == 5) {
            result += "V";
        }else if (b > 5 && b <= 8){
            result += "V";
            for(int i = 0; i < b - 5; i++){
                result += "I";
            }
        }else if(b == 9) {
            result += "IX";
        }else{
            result += "";
        }
        System.out.println(result);
    }
}
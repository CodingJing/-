/*
1、将身份证号码前17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；
2、将这17位数字和系数相乘的结果相加；
3、用加出来和除以11，看余数是多少；
4、余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2；
*/

public class Main {


    public static void main(String[] args) {
        // String i =  CheckSFZ("410782200301099549");
       String i =  CheckSFZ("420303200108201542");
        System.out.println(i);
    }

    public static String CheckSFZ(String SFZ) {
        //系数数组定义
        int[] factors = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        //2.求和
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (SFZ.charAt(i) - '0') * factors[i];//
        }
        //3.取余
        int remainder = sum % 11;
        //4.余数映射数组定义
        char[] mappedDigits = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        //5.生成最后一位（校验位）
        char lastDigit = mappedDigits[remainder];
        if (lastDigit==SFZ.charAt(17)){
            return SFZ;
        }else {
            return "error";
        }

    }

}

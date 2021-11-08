/*
        题目要求
        模拟中国体彩七星彩，随机产生一个包含7个数码的数，用户从键盘输入自己的幸运数据，
        判断是否中奖，如果中奖输出中奖等级
        中奖条件：对应位置相同的数据数
        等级：2位数相同：五等奖
        5位数相同：特等奖
    软件设计：
    7位数由Python标准库random模块中的函数提供
    分析：对于random.randrange(x,y)，返回[x,y]数据区间的随机整数，初步判断无法实现满足条件的随机数0
        以至于期望结果0000000被错误表示
        解决办法：对于此，初步判断使用循环嵌套，上界定9，下界定0，在其中产生随机数，循环产生并装入数组
                最后得到一个容量为7个随机数的数组
                对于用户输入的数据 采用相同的办法，循环输入数据并装入数组
                最后对两个数组进行匹配
                拟定判断条件，判断两个数组的相同位置的个数并进行等级判定
 */
import java.util.Scanner;
import java.lang.String;
import java.util.Random;

public class lotteryDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] arrayA = new int[7];
        int[] arrayB = new int[7];

        for (int i = 0; i < arrayA.length ; i++) {
            System.out.println("Please enter one number from keyboards:");
             arrayA[i]= Integer.parseInt(input.next());
        }

        System.out.println("Your lottery number is:" );
        for (int i = 0; i < arrayA.length; i++) {
            System.out.print(arrayA[i]);
        }
        System.out.println();
        System.out.println("================================");

        Random rand = new Random();
        System.out.println("The lottery results is :");
        for (int i = 0; i < arrayB.length; i++) {
            int num = rand.nextInt(10);
            System.out.print(num);
            arrayB[i]=num;
        }
        System.out.println();

        int initial = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i]==arrayB[i]){
                System.out.println(arrayA[i] + " is the same as " + arrayB[i]);
                initial = initial +1;

            }

        }
        System.out.println("According to the match, you have " + initial + " numbers that are the same");

        System.out.println("================================");
        System.out.println();
        switch (initial){
            case 2:
                System.out.println("You won the second prize");
            break;

            case 5:
                System.out.println("You won the grand prize");
            break;

            default:
                System.out.println("Sorry, you didn't win the prize. Please keep trying");
        }
    }
}

import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        double a = in.nextDouble();//вводим с клавиатуры вещественные числа а и b//
        double b = in.nextDouble();
        if (b>0){ //начинаю рассматривать врианты. Первый - если коэф. b >0//
           if (a >0){ //при b >0 рассматриваю первый случай - коэф. а - положительный//
               out.println("x ∈ (0;");
               out.print(1/a);
               out.print(")");
            }
           else if (a == 0){ // второй случай при b>0 - коэф. а равен нулю//
               out.println("x ∈ (0; +∞)");
           }
           else { // третий случай при b>0 - коэф. а отрицательный //
               out.println("x ∈ (-∞;");
               out.print(1/a);
               out.print(") ⋃ (0;+∞)");
           }
        }
        else if (b==0){ //второй случай для коэф. b - если он равен нулю. В такой ситуации нет решений у неравенства//
            out.println("x ∈ Ø");
        }
        else { //последний возможный случай для коэф. b - если он отрицательный//
            if (a >0){ //случай b<0  и a>0//
                out.println("x ∈ (-∞;0) ⋃ (");
                out.print(1/a);
                out.print(";+∞)");
            }
            else if(a ==0){//случай: b<0 и a=0//
                out.println("x ∈ (-∞;0)");
            }
            else{ //случай: b<0 и a<0//
                out.println("x ∈ (");
                out.print(1/a);
                out.print(";0)");
            }
        }
    }
}

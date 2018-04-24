package view;

import java.util.Scanner;

public class InputView {

    public static String inputName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("플레이어 이름은(3 english letters)?:");
        return sc.nextLine();
    }

    public static int inputScore(int frameNum){
        Scanner sc = new Scanner(System.in);
        System.out.println(frameNum+"프레임 투구 :");
        return sc.nextInt();
    }


}

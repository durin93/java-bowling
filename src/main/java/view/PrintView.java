package view;

import com.sun.javafx.binding.StringFormatter;
import domain.Round;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintView {

    public static void printBaseBoard(){
        System.out.print("| Name |");
        System.out.print(IntStream.range(1,11).mapToObj(i -> String.format("%4d",i)).collect(Collectors.joining(" | ")));
        System.out.println("|");
    }

    public static void printPinBoard(String name, Round round){
        System.out.print("|  "+name+" |");
        System.out.print(round.getFrames().stream().map(frame ->  frame.toString()).collect(Collectors.joining(" | ")));
        System.out.print(IntStream.range(round.frameSize(),11).mapToObj(empty -> "   ").collect(Collectors.joining(" | ")));
        System.out.println("|");
    }

    public static void printScoreBoard(Round round){
        System.out.print("|      |");
        System.out.print(IntStream.range(1,11).mapToObj(i -> String.format("%4d",i)).collect(Collectors.joining(" | ")));
        System.out.println("|");
    }

}

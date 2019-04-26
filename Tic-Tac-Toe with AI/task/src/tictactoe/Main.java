package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Enter cells:" + str);
        GameField game = new GameField(str);
        System.out.println(game.printField());
        boolean flag = false;
        do{
            String xy = scanner.nextLine();
            System.out.println("Enter the coordinates: " + xy);
            int[] coordinate = parseCoordinates(xy);
            if (coordinate[0] != -1){
                if(game.moveAs(coordinate[0], coordinate[1], "X")){
                    flag = false;
                }else{
                    System.out.println("This cell is occupied! Choose another one!");
                    flag = true;
                }
            }else {
                flag = true;
            }
        } while(flag);



        System.out.println(game.printField());
    }

    private static int[] parseCoordinates(String str){
        int [] answer = new int[2];
        try{
            String[] record = str.split(" ");
            if((1 <= Integer.parseInt(record[0])) &&(Integer.parseInt(record[0]) <=3) &&
                    (1 <= Integer.parseInt(record[1])) &&(Integer.parseInt(record[1]) <=3)){
                answer[0] = Integer.parseInt(record[0]);
                answer[1] = Integer.parseInt(record[1]);
                return answer;
            }else{
                System.out.println("Coordinates should be from 1 to 3!");
                answer[0] = -1;
                return answer;
            }
        }catch (Exception e){
            System.out.println("You should enter numbers!");
            answer[0] = -1;
            return answer;
        }
    }
}

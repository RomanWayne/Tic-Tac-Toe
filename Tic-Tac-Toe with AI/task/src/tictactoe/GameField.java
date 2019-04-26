package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<Cell> field;
    private int size = 3;

    public GameField() {
        field = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                field.add(new Cell(i, j, ""));
            }
        }
    }

    public GameField(String str) {
        field = new ArrayList<>();
        if (str.contains("\"")){
            str = str.replace("\"", "");
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                field.add(new Cell(i, j, str.substring(i* size + j, i* size + j + 1)));
            }
        }
    }

    public String printField(){
        StringBuilder sb = new StringBuilder();
        sb.append("---------").append("\n").append("| ");
        for(int i = 0; i < field.size(); i++){
            if((i + 1) % size != 0){
                sb.append(field.get(i).getState()).append(" ");
            }else if((i + 1) != size * size){
                sb.append(field.get(i).getState()).append(" |").append("\n").append("| ");
            } else{
                sb.append(field.get(i).getState()).append(" |").append("\n").append("---------");
            }
        }
        return sb.toString();
    }



    private Cell getCell(int i, int j){
        int index = i*size + j;
        return field.get(index);
    }


    private boolean isWin(String player){
        StringBuilder winStr = new StringBuilder().append(player).append(player).append(player);
        StringBuilder curStr = new StringBuilder();
        //проверяем все строки
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                curStr.append(getCell(i, j).getState());
            }
            if(curStr.toString().equals(winStr.toString())){
                return true;
            }else{
                curStr.setLength(0);
            }
        }
        //проверяем все столбцы
        for(int j = 0; j < size; j++){
            for(int i = 0; i< size; i++){
                curStr.append(getCell(i, j).getState());
            }
            if(curStr.toString().equals(winStr.toString())){
                return true;
            }else{
                curStr.setLength(0);
            }
        }
        //проверяем обе диагонали
        for(int i = 0; i < size; i++){
            curStr.append(getCell(i, i).getState());
        }
        if(curStr.toString().equals(winStr.toString())){
            return true;
        }else{
            curStr.setLength(0);
        }
        int i;
        int j;
        for(i = 0, j = size - 1; j >= 0; i++, j--){
            curStr.append(getCell(i, j).getState());
        }
        if(curStr.toString().equals(winStr.toString())){
            return true;
        }else{
            curStr.setLength(0);
        }
        return false;
    }

    private boolean isImpossible(){
        if(isWin("X") && isWin("O")){
            return true;
        }
        int cntO = 0;
        int cntX = 0;
        for(int i = 0; i < field.size(); i++){
            if(field.get(i).getState().equals("O")){
                cntO++;
            }else if(field.get(i).getState().equals("X")){
                cntX++;
            }
        }
        if(Math.abs(cntO - cntX) > 1){
            return true;
        }
        return false;
    }

    private boolean isExistsEmpty(){
        for(int i = 0; i < field.size(); i++){
            if(field.get(i).getState().equals(" ")){
                return true;
            }
        }
        return false;
    }

    public String analizeField(){
        if(isImpossible()){
            return "Impossible";
        } else if(isWin("X")){
            return "X wins";
        } else if(isWin("O")){
            return "O wins";
        } else if(!isWin("X") && !isWin("O") && !isExistsEmpty()){
            return "Draw";
        }
        return "Game not finished";
    }

    public boolean moveAs(int x, int y, String player){
        if(getCell(size - y, x - 1).getState().equals(" ")) {
            getCell(size - y, x - 1).setState(player);
            return true;
        }
        return false;
    }
}

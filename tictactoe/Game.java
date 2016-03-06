import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Game {

    private int[][] table;
    public Game() {
        table = new int [3][3];
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                table[r][c] = 0;
            }
        }
    }
    public void tableTest(Graphics g, int size, int x, int y) {
        g.setColor(Color.black);
        int r = 0;
        int c = 0;
        for(int i = 0; i < (size/3)*3;i += size/3) {
            r = 0;
            for(int j = 0; j < (size/3)*3;j += size/3) {
                g.drawRect(i+x,j+y,size/3,size/3);
                if(table[r][c] == 1) {
                    g.drawOval(i+x+size/20,j+y+size/20,(size/3)-size/10,(size/3)-size/10);
                }
                if(table[r][c] == 2) {
                    g.drawRect(i+x+size/20,j+y+size/20,(size/3)-size/10,(size/3)-size/10);
                }
                r++;
            }
            c++;
        }
    }
    public void drawMe(Graphics g) {
        g.setColor(Color.black);
        for(int i = 100; i < 400;i += 100) {
            for(int j = 100; j < 400;j += 100) {
                g.drawRect(i,j,100,100);
                if(table[j/100-1][i/100-1] == 1) {
                    g.drawOval(i+25,j+25,50,50);
                }
                if(table[j/100-1][i/100-1] == 2) {
                    g.drawRect(i+25,j+25,50,50);
                }
            }
        }
    }
    public void reset() {
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                table[r][c] = 0;
            }
        }
    }
    public void printTable() {
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                System.out.print(table[r][c] + " ");
            }
            System.out.println();
        }
    }
    public boolean checkFull(int r, int c) {
        if(table[r][c] == 0) {
            return true;
        }
        return false;
    }
    public boolean turn(int r, int c, boolean player) {
        if (table[r][c] == 0 && player) {
            table[r][c] = 1;
            return true;
        }
        else if(table[r][c] == 0  && !player) {
            table[r][c] = 2;
            return true;
        }
        return false;
    }
    public boolean checkFull() {
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                if (table [r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkTicTacToe1() {
        for(int i = 0; i < 3;i++) {
            if(table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 1) {
                    return true;
            }
            if(table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 1) {
                return true;
            }
        }
        if(table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1) {
            return true;
        }
        if(table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1) {
            return true;
        }
        return false;
    }
    public boolean checkTicTacToe2() {
        for(int i = 0; i < 3;i++) {
                if(table[i][0] == 2 && table[i][1] == 2 && table[i][2] == 2) {
                    return true;
                }
                if(table[0][i] == 2 && table[1][i] == 2 && table[2][i] == 2) {
                    return true;
                }
        }
        if(table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2) {
            return true;
        }
        if(table[0][2] == 2 && table[1][1] == 2 && table[2][0] == 2) {
            return true;
        }
        return false;
    }
}



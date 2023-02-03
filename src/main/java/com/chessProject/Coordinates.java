package com.chessProject;

import java.util.Objects;

public class Coordinates {

    private final int x;
    private final int y;
    private String chessCoordinates;

    public Coordinates(String chessCoordinates) {
        this.chessCoordinates = chessCoordinates;
        char file = chessCoordinates.charAt(0);
        int rank = Integer.parseInt(Character.toString(chessCoordinates.charAt(1)));
        x = getXForFile(file);
        y = getYForRank(rank);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("%s -> %d%d", chessCoordinates, x, y);
    }

    public int getXForFile(char file) {
        return file - 97;
    }

    public int getYForRank(int rank) {
        return 8-rank;
    }

    public Coordinates getOffset(int x, int y) {
        return new Coordinates(this.x + x, this.y + y);
    }

    public String getArrayCoords(String chessCoordinates) {
        char file = chessCoordinates.charAt(0);
        int rank = Integer.parseInt(Character.toString(chessCoordinates.charAt(1)));
        int x = getXForFile(file);
        int y = getYForRank(rank);
        return String.format("%d, %d", x, y);
    }

    public boolean isPermittedMove(Coordinates[] validMoves) {
        for(int x = 0; x < validMoves.length; x++) {
            if(validMoves[x].equals(this))
                return true;
        }
        return false;
    }
}

//    public char getHorizontalCoord(int x) {
//        return (char) (x + 96);
//    }
//
//    public char getVerticalCoord(int y) {
//        return (char) (y + 48);
//    }

//    public String getCoordinates(String chessCoords) {
//        char[] arr = chessCoords.toCharArray();
//        String x = String.valueOf(arr[0]);
//        String y = String.valueOf(arr[1]);
//        return String.format("%s,%s", x, y);
//    }

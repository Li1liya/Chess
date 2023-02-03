package com.chessProject;

import static com.chessProject.ChessPiece.Color.WHITE;

public abstract class ChessPiece {

    protected Color color;
    protected Coordinates coordinates;

    public ChessPiece(Color color) {
        this.color = color;
    }

    protected void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected int calcYWithDirFactor(int yOffset) {
        int dirFactor = color == WHITE ? -1 : 1;
        return yOffset * dirFactor;
    }

    abstract Coordinates[] getValidMoves();

    enum Color {
        WHITE, BLACK;
    }
}

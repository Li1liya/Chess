package com.chessProject;

import java.util.Arrays;

import static com.chessProject.ChessPiece.Color.WHITE;

public class ChessBoard {
    private ChessPiece[][] internalBoard = new ChessPiece[8][8];
    private ChessPiece[] whiteCapturedPieces = new ChessPiece[0];
    private ChessPiece[] blackCapturedPieces = new ChessPiece[0];

    public void add(ChessPiece chessPiece, String chessCoords) {
        Coordinates coordinates = new Coordinates(chessCoords);
        chessPiece.setCoordinates(coordinates);
        internalBoard[coordinates.getX()][coordinates.getY()] = chessPiece;
    }

    public ChessPiece getPieceAtCoords(String chessCoords) {
        Coordinates coordinates = new Coordinates(chessCoords);
        return internalBoard[coordinates.getX()][coordinates.getY()];
    }

    public void move(ChessPiece chessPiece, String destCoordinates) {
        Coordinates origin = chessPiece.coordinates;
        Coordinates destination = new Coordinates(destCoordinates);
        if(destinationIsOccupiedByFriendly(chessPiece, destination)) {
            return;
        } else if (destinationIsOccupiedByEnemy(chessPiece, destination)) {
            ChessPiece capturedPiece = getPieceAtCoords(destCoordinates);
            capturedPiece.setCoordinates(null);
            if (chessPiece.color == WHITE) {
                whiteCapturedPieces = addToCapturedPieces(capturedPiece, whiteCapturedPieces);
            } else {
                blackCapturedPieces = addToCapturedPieces(capturedPiece, blackCapturedPieces);
            }
        }
        performActualMove(chessPiece, destCoordinates, origin, destination);
    }

    private ChessPiece[] addToCapturedPieces(ChessPiece capturedPiece, ChessPiece[] capturedPieces) {
        ChessPiece[] tmpCaptured = Arrays.copyOf(capturedPieces, capturedPieces.length + 1);
        tmpCaptured[capturedPieces.length] = capturedPiece;
        return tmpCaptured;
    }

    private boolean destinationIsOccupiedByEnemy(ChessPiece piece, Coordinates destination) {
        ChessPiece destinationPiece = internalBoard[destination.getX()][destination.getY()];
        return destinationPiece != null && destinationPiece.color != piece.color;
    }

    public boolean destinationIsOccupiedByFriendly(ChessPiece piece, Coordinates destination) {
        ChessPiece destinationPiece = internalBoard[destination.getX()][destination.getY()];
        return destinationPiece != null && destinationPiece.color == piece.color;
    }

    public void performActualMove(ChessPiece piece, String destCoordinates, Coordinates origin, Coordinates destination) {
        if (destination.isPermittedMove(piece.getValidMoves())) {
            internalBoard[origin.getX()][origin.getY()] = null;
            add(piece, destCoordinates);
        }
    }

    public ChessPiece[] getWhiteCapturedPieces() {
        return whiteCapturedPieces;
    }
}

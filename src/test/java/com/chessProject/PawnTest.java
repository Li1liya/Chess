package com.chessProject;

import org.junit.jupiter.api.Test;

import static com.chessProject.ChessPiece.Color.BLACK;
import static com.chessProject.ChessPiece.Color.WHITE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest extends ChessPieceTest{

    @Test
    public void canMoveOneForward() {
        Pawn pawn = new Pawn(WHITE);
        pawn.setCoordinates(new Coordinates("a2"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a3");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination), String.format("Move '%s' not found.", expectedDestination));
    }

    @Test
    public void canMoveTwoForwardOnFirstMove() {
        Pawn pawn = new Pawn(WHITE);
        pawn.setCoordinates(new Coordinates("a2"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a4");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination));
    }

    @Test
    public void canNotMoveTwoAfterFirstMove() {
        Pawn pawn = new Pawn(WHITE);
        pawn.setCoordinates(new Coordinates("a2"));
        pawn.setCoordinates(new Coordinates("a3"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a5");
        assertFalse(isMoveFoundInArray(validMove, expectedDestination));
    }

    @Test
    public void canMoveOneDiagonallyRight() {
        Pawn pawn = new Pawn(WHITE);
        pawn.setCoordinates(new Coordinates("a2"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b3");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination));
    }

    @Test
    public void canMoveOneDiagonallyLeft() {
        Pawn pawn = new Pawn(WHITE);
        pawn.setCoordinates(new Coordinates("b2"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a3");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination));
    }

    @Test
    public void blackPawnCanMoveForward() {
        Pawn pawn = new Pawn(BLACK);
        pawn.setCoordinates(new Coordinates("b7"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b6");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination));
    }

    @Test
    public void blackPawnCanMoveTwoForward() {
        Pawn pawn = new Pawn(BLACK);
        pawn.setCoordinates(new Coordinates("b7"));
        Coordinates[] validMove = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b5");
        assertTrue(isMoveFoundInArray(validMove, expectedDestination));
    }

}

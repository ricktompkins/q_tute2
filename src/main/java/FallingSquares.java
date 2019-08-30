import bagel.*;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;

/**
 *      FallingSquares is a game that extends the bagel AbstractGame class.
 *
 *      Description: A player will begin with an empty screen. At the start of the game, a square will appear at the
 *      top center of the window and fall until it reaches the bottom of the screen, where it will stop.
 *      Another square will then appear at the top of the screen, decided by where ever the player's mouse cursor is.
 *      It will then also fall, and either collide with the floor or another block and remain there. This will continue
 *      until the player presses escape.
 *
 *      Steps:
 *         1. Have square fall to the bottom
 *         2. Add collision checking for the bottom of the playable area (top left is 0, 0).
 *         3. Have additional square spawn when it stops at the bottom
 *         4. Make square spawn at mouse cursor
 *         5. Add collisions for the other squares
 *
 *
 */

public class FallingSquares extends AbstractGame {

    private final int WIDTH;
    private final int HEIGHT;
    private final static int TOP = 0;

    private double speed = 3f;

    private Square fallingSquare;
    private ArrayList<Square> squares;

    /**
     * The constructor for the game should initialise any data structures needed for storing squares as well as the first
     * square itself.
     *
     * @param width
     * @param height
     * @param name
     */

    public FallingSquares(int width, int height, String name) {

        super(width, height, name);

        this.WIDTH = width;
        this.HEIGHT = height;

        fallingSquare = new Square(WIDTH / 2, TOP);
        squares = new ArrayList<>();

    }

    /**
     *
     * The update function should:
     *      1. Move the square
     *      2. Check if it hits the bottom of the screen / other squares
     *      3. Spawn a new square
     *      4. Repeat
     *
     * @param input
     */

    @Override
    protected void update(Input input) {

        if(!checkCollisions()) {
            fallingSquare.move(0, speed);
        } else {
            squares.add(fallingSquare);
            createSquare(input);
        }
        fallingSquare.render();

        for(Square square : squares) {
            square.render();
        }


    }

    /**
     *
     * the checkCollisions function should return a boolean to indicate whether the current falling square has
     * made contact with either the bottom of the screen, or another square
     *
     * @return
     */

    private boolean checkCollisions() {

        for (Square square : squares) {
            if(square.checkCollision(fallingSquare)){
                return true;
            }
        }
        return fallingSquare.getY() + fallingSquare.getHeight() / 2 > HEIGHT;
    }

    /**
     *  after the initial square has been created, any new squares should use the player's mouse cursor to select the
     *  next location.
     *
     * @param input
     */

    private void createSquare(Input input) {
        fallingSquare = new Square(input.getMouseX(), 0);

    }


}

/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {
	private static final long serialVersionUID = -6216973682616055961L;
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 700;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	public static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	public static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	public static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	Paddle paddle = new Paddle(100,100, PADDLE_WIDTH, PADDLE_HEIGHT);
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		add(paddle);

		addMouseListeners();
		addKeyListeners();
		for(int i = 0; i<NBRICK_ROWS; i++) {
			row++;
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {

				Brick brick = new Brick((BRICK_WIDTH + BRICK_SEP) * j, BRICK_Y_OFFSET+i*(BRICK_HEIGHT+BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);

				add(brick);
			}
		}
		while(true) {
			paddle.move();
			pause(2);
		}
	}

	public void mouseMoved(MouseEvent e)
	{
		Paddle.MouseX = e.getX();
		System.out.println(Paddle.MouseX);
		Paddle.MouseY = e.getY();
	}
	protected static int row = 0;

}

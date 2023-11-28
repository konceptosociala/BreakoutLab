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
	public static final int WIDTH = APPLICATION_WIDTH;
	public static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	public static final int PADDLE_WIDTH = 60;
	public static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	public static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	public static final int NBRICKS_PER_ROW = 4;

/** Number of rows of bricks */
	public static final int NBRICK_ROWS = 4;

/** Separation between bricks */
	public static final int BRICK_SEP = 4;

/** Width of a brick */
	public static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	public static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	public static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	public static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	public static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void init() {
		addMouseListeners();
		addKeyListeners();
	}
	
	public void run() 
	{
		new Game(new WindowDescriptor("Breakout", APPLICATION_WIDTH, APPLICATION_HEIGHT, this))
			.addSystem(new MainMenuSystem())
			.addSystem(new ExitSystem())
			.addSystem(new GameOverSystem())
			.addSystem(new Level1System())
			.addSystem(new YouWinSystem())
			.run();
	}
	
	public void mouseClicked(MouseEvent e)
	{
		GPoint p = new GPoint(e.getPoint()); 
		GObject o = getElementAt(p); 
		
		if (o instanceof Button) {
			((Button) o).onClick(e);
		}
	}

	public void mouseMoved(MouseEvent e)
	{
		Paddle.MouseX = e.getX();
		Paddle.MouseY = e.getY();
	}
	
	protected static int row = 0;
}

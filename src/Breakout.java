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

import javax.sound.sampled.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Breakout extends GraphicsProgram {
	private static final long serialVersionUID = -6216973682616055961L;
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 700;

/** Dimensions of game board (usually the same) */
	public static final int WIDTH = APPLICATION_WIDTH;
	public static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	public static final int PADDLE_WIDTH = 70;
	public static final int PADDLE_HEIGHT = 13;

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

	/**
	 * Runs the Breakout program, initiating the game loop.
	 * It sets up the game systems and runs the game.
	 */
	public void run() 
	{
		playMusic("src\\music\\gameMusic.wav");
		new Game(new WindowDescriptor("Breakout", APPLICATION_WIDTH, APPLICATION_HEIGHT, this))
			.addSystem(new MainMenuSystem())
			.addSystem(new SelectLevelSystem())
			.addSystem(new ExitSystem())
			.addSystem(new GameOverSystem())
			.addSystem(new Level1System())
			.addSystem(new Level2System())
			.addSystem(new Level3System())
			.addSystem(new YouWinSystem())
			.run();
	}
	/**
	 * Handles the mouseClicked event, checking if a Button was clicked and triggering its onClick method.
	 *
	 * @param e The MouseEvent representing the mouse click.
	 */
	public void mouseClicked(MouseEvent e)
	{
		GPoint p = new GPoint(e.getPoint()); 
		GObject o = getElementAt(p); 
		
		if (o instanceof Button) {
			((Button) o).onClick(e);
		}
	}
	/**
	 * Handles the mouseMoved event, updating the Paddle's position based on the mouse movement.
	 *
	 * @param e The MouseEvent representing the mouse movement.
	 */
	public void mouseMoved(MouseEvent e)
	{
		Paddle.MouseX = e.getX();
		Paddle.MouseY = e.getY();
	}
	/**
	 * Plays background music based on the provided file path.
	 *
	 * @param filepath The file path of the audio file to be played.
	 */
	public static void playMusic(String filepath) {
		try {
			File audioFile = new File(filepath);

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);

			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}

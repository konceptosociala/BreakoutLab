import java.awt.Color;

import acm.graphics.GLabel;

public class Health extends GLabel
{
	private int maxPoints;
	private int points;
	private String label;
	/**
	 * Constructs a Health object with the specified initial health points.
	 * Initializes the health label, font, color, and graphical properties.
	 *
	 * @param healthPoints The initial health points.
	 */
	public Health(int healthPoints) 
	{
		super("", 5, 25);
		this.points = healthPoints;
		this.maxPoints = healthPoints;
		this.setFont("Monospaced-24");
		this.setColor(Color.RED);
		this.label = "Health: ";
		
		for (int i = 0; i < healthPoints; i++) {
			this.label += "♥ ";
		}
		
		this.setLabel(label);
	}
	/**
	 * Decreases the health points by the specified amount.
	 * Plays a negative beep sound when health is decreased.
	 *
	 * @param healthPoints The amount to decrease the health points.
	 */
	public void decrease(int healthPoints) 
	{
		if (this.points > 0) 
		{
			points -= healthPoints;
			Breakout.playMusic("src\\music\\negative_beeps.wav");
		}
		
		this.label = "Health: ";
		
		for (int i = 0; i < points; i++) {
			this.label += "♥ ";
		}
		
		this.setLabel(label);
	}
	/**
	 * Increases the health points by the specified amount, up to the maximum.
	 *
	 * @param healthPoints The amount to increase the health points.
	 */
	public void increase(int healthPoints) 
	{
		points += Math.min(healthPoints, maxPoints);
		
		this.label = "Health: ";
		
		for (int i = 0; i < points; i++) {
			this.label += "♥ ";
		}
		
		this.setLabel(label);
	}
	/**
	 * Checks if the health points have reached zero.
	 *
	 * @return {@code true} if health points are zero, {@code false} otherwise.
	 */
	public boolean isDead() {
		return points == 0;
	}
}

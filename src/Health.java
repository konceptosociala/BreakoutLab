import java.awt.Color;

import acm.graphics.GLabel;

public class Health extends GLabel
{
	private int maxPoints;
	private int points;
	private String label;
	
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
	
	public void decrease(int healthPoints) 
	{
		if (this.points > 0) 
		{
			points -= healthPoints;
		}
		
		this.label = "Health: ";
		
		for (int i = 0; i < points; i++) {
			this.label += "♥ ";
		}
		
		this.setLabel(label);
	}
	
	public void increase(int healthPoints) 
	{
		points += Math.min(healthPoints, maxPoints);
		
		this.label = "Health: ";
		
		for (int i = 0; i < points; i++) {
			this.label += "♥ ";
		}
		
		this.setLabel(label);
	}
	
	public boolean isDead() {
		return points == 0;
	}
}

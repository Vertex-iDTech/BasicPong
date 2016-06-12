package basicpong;


import java.awt.Color;

import processing.core.PApplet;

// A basic pong game. Can be customized by changing variables
public class BasicPong extends PApplet {
	
	
	
	/************************* Change the variables here ***************************/
	
	// gameplay variables
	int gameWidth  = 600;	// Width of the pong game (in pixels)
	int gameHeight = 600;	// Height of the pong game (in pixels)
	float speedX   = 4;		// Horizontal speed of ball
	float speedY   = 3;     // Vertical speed of ball
	int paddleSize = 150;   // Size of the paddle
	
	// color variables
	Color wallColor       = Color.gray;		// try replacing "gray" with "blue
	Color paddleColor     = Color.gray;
	Color ballColor       = Color.gray;
	Color backgroundColor = Color.white;
	
	// characters and strings
	String gameTitle  = "Pong";
	char firstInitial = 'A';
	char lastInitial  = 'E';
	int fontSize      = 24;
	Color fontColor   = Color.gray;
	
	/**************************    End of variables     *************************/
	
	
	
	// other variables, DON'T TOUCH!
	float x = gameWidth/2;
	float y = gameHeight/2; 
	int diam;
	
	// sets up the game before first frame
	public void setup() {
		  size(gameWidth, gameHeight);
		  noStroke();
		  smooth();
		  ellipseMode(CENTER);
		  textAlign(CENTER);
		  textSize(fontSize);
	}

	// runs once per frame. Updates state of the game and draws game to screen.
	public void draw() {
		
		// draw background and game/creator name
		background(backgroundColor.getRGB());
		fill(fontColor.getRGB());
		text(gameTitle + " by: " + firstInitial + ". " + lastInitial + ".", gameWidth/2, gameHeight/8);

		// update the ball's location
		x = x + speedX;
		y = y + speedY;

		// if ball hits movable bar, invert X direction and apply effects
		if (x > width - 30 && x < width - 20 && y > mouseY - paddleSize / 2 && y < mouseY + paddleSize / 2) {
			speedX = speedX * -1;
			x = x + speedX;
		}

		// if ball hits wall, change direction of X
		else if (x < 25) {
			speedX = speedX * -1;
			x = x + speedX;
		}

		// resets things if you lose
		if (x > width) {
			print("ran");
			x = gameWidth / 2;
			y = gameHeight / 2;
		}

		// if ball hits up or down, change direction of Y
		if (y > height || y < 0) {
			speedY = speedY * -1;
			y = y + speedY;
		}
		
		// draw the ball
		fill(ballColor.getRGB());
		diam = 20;
		ellipse(x, y, diam, diam);

		// draw the wall
		fill(wallColor.getRGB());
		rect(0, 0, 20, height);
		fill(paddleColor.getRGB());
		rect(width - 30, mouseY - paddleSize / 2, 10, paddleSize);
	}
}
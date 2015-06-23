import java.util.ArrayList;

import apcs.Window;


public class Frogger {

	static int x = 400, y = 0;
	static int cooldown = 5;
	static int carx = -100, cary = Window.rollDice(3) * 100 + 50;
	static int carwidth = Window.rollDice(5) * 25 + 50;
	static int score = 0, highscore = 0, deaths = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window.size(2000,1000);
		Frog f = new Frog();
		ArrayList<Car> cars = new ArrayList<Car>();

		for (int i = 0; i < 10; i++) {
			if (Window.rollDice(10) <= 5) {
				cars.add(new Car(-1));
			}
			else {
				cars.add(new Car(1));
			}
		}

		while (true) {
			drawBackground();
			f.draw();
			f.move();
			for (int i=0; i < cars.size(); i++) {
				cars.get(i).draw();
				cars.get(i).move();

				if (cars.get(i).checkcollision(f)){
					f.reset();
					deaths++;
					//cars.get(i).reset();
				}
			}
			if (f.y < -f.radius) {
				score++;
				f.reset();
			}
			if (score > highscore) {
				highscore = score;
			}
			Window.frame();
		}
	}
	/**
	private static void checkcollision() {
		// TODO Auto-generated method stub
		if (Math.abs(x - carx) <= carwidth / 2 + 25 && Math.abs(y - cary) <= 40 + 25) {
			Window.frame(500);
			x = 400;
			y = 450;
			carx = -100;
			cary = Window.rollDice(3) * 100 + 50;
		}
	}
	private static void moveCar() {
		// TODO Auto-generated method stub
		carx += 10;
		if (carx >= Window.width() + carwidth / 2) {
			carx = -100;
			cary = Window.rollDice(3) * 100 + 50;
		}
	}
	private static void drawCar() {
		// TODO Auto-generated method stub
		Window.out.color("red");
		Window.out.rectangle(carx, cary, carwidth, 80)
		;	}
	private static void moveFrog() {
		if (Window.key.pressed("up") && cooldown >= 5) {
			y -= 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("down") && cooldown >= 5) {
			y += 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("right") && cooldown >= 5) {
			x += 50;
			cooldown = 0;
		}
		else if (Window.key.pressed("left") && cooldown >= 5) {
			x -= 50;
			cooldown = 0;
		}
	}
	private static void drawFrog() {
		Window.out.color("light green");
		Window.out.circle(x, y, 25);
	}**/

	private static void drawBackground() {
		// TODO Auto-generated method stub
		//background
		Window.out.background("grey");

		//grass
		Window.out.color("dark green");
		Window.out.rectangle(Window.width() / 2, 50, Window.width(), 100);
		Window.out.rectangle(Window.width() / 2, 750, Window.width(), 700);

		//road lines
		Window.out.color("yellow");
		for (int i = 0; i < Window.width() / 100; i++) {
			Window.out.rectangle(50 + (i * 100), 200, 50, 10);
			Window.out.rectangle(50 + (i * 100), 300, 50, 10);
		}
		//score and deaths
		Window.out.color("white");
		Window.out.font("monospace", 30);
		Window.out.print("Score: " + score, 25, 450);
		Window.out.print("High Score: " + highscore, 550, 450);
		Window.out.print("Roadkill: " + deaths, 350, 25);
	}

}

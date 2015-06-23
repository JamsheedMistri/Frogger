import apcs.Window;


public class Frog {
	int x, y, speed, radius, cooldown;
	
	public Frog() {
		x = Window.width() / 2;
		y = 450;
		radius = 25;
		cooldown = 5;
		
	}
	public void draw() {
		Window.out.color("light green");
		Window.out.image("frog.png", x-25, y-15);
	}
	public void move() {
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
		cooldown++;
	}
	public void reset() {
		// TODO Auto-generated method stub
		x = Window.width() / 2;
		y = Window.height() - 50;
	}
}

import apcs.Window;

public class Car {
	int x, y, speed, width, height, direction; //direction = 1 or -1
	int r, g, b;

	public Car(int direction) {
		this.direction = direction;
		if (direction == -1) {
			x = Window.width() + 100;
		}
		else {
			x = -100;
		}
		y =  Window.rollDice(3) * 100 + 50;
		width =  Window.rollDice(3) * 25 + 50;
		speed =  Window.rollDice(10) + 10;
		height = 80;
		r = Window.rollDice(256) - 1;
		g = Window.rollDice(256) - 1;
		b = Window.rollDice(256) - 1;
	}
	public void draw() {
		Window.out.color(r,g,b);
		Window.out.rectangle(x, y, width, height);
	}
	public void move() {
		// TODO Auto-generated method stub
		x += speed * direction;
		if (direction == 1) {

			if (x >= Window.width() + width / 2) {
				x = -100;
				y = Window.rollDice(3) * 100 + 50;
			}
		}
		else {
			if(x<= -width/2) {
				x = Window.width() + 100;
				y = Window.rollDice(3) * 100 + 50;
			}
		}
	}

	public boolean checkcollision(Frog f) {
		if (Math.abs(x - f.x) <= width / 2 + f.radius && Math.abs(y-f.y)<=height / 2 - f.radius) {
			return true;
		}
		return false;
	}
	public void reset() {
		// TODO Auto-generated method stub
		if (direction == -1) {
			x = Window.width() + 100;
		}
		else {
			x = -100;
		}
		y =  Window.rollDice(3) * 100 + 50;
		width =  Window.rollDice(3) * 25 + 50;
		speed =  Window.rollDice(10) + 10;
	}
}

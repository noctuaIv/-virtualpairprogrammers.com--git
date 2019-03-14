import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class CreateLogo {

	public static void main(String[] args) throws IOException {
		int width = 300;
		int height = 200;
		BufferedImage bi = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bi.createGraphics();
		Font font = new Font("Arial", Font.BOLD, 24);
		g.setFont(font);

		g.setBackground(Color.black);
		g.clearRect(0, 0, width, height);

		g.setPaint(Color.green);
		g.fillOval(-200, -100, 400, 400);

		g.setPaint(Color.red);
		g.drawString("Capital", 150, 25);
		g.drawString("City", 150, 75);
		g.drawString("Guessing", 150, 125);
		g.drawString("Game", 150, 175);
		ImageIO.write(bi, "PNG", new File("logo.png"));
	}
}
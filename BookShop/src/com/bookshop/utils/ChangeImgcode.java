
package com.bookshop.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 张家宝
 * @data 2020年5月4日 下午6:05:38
 * @describe 
 */
public class ChangeImgcode {

	public  void changeImg(HttpSession session,HttpServletResponse response,List<String> words) throws IOException {
		int width = 120;
		int height = 30;


		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

	
		Graphics graphics = bufferedImage.getGraphics();
	
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);

	
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width - 1, height - 1);


		Graphics2D graphics2d = (Graphics2D) graphics;

		graphics2d.setFont(new Font("宋体", Font.BOLD, 18));

		Random random = new Random();
		int index = random.nextInt(words.size());
		String word = words.get(index);

	
		int x = 10;
		for (int i = 0; i < word.length(); i++) {
		
			graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
		
			int jiaodu = random.nextInt(60) - 30;
			
			double theta = jiaodu * Math.PI / 180;

			
			char c = word.charAt(i);

			
			graphics2d.rotate(theta, x, 20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(-theta, x, 20);
			x += 30;
		}	
		session.setAttribute("checkcode_session", word);
		System.out.println("session---------code"+word);
		graphics.setColor(getRandColor(160, 200));
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0; i < 30; i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
		}

	
		graphics.dispose();
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		

		
	}
	public  Color getRandColor(int fc, int bc) {

		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
}

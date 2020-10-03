package in.naresh.manoj;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.SquigglesBackgroundProducer;
import cn.apiclub.captcha.noise.StraightLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;

public class CaptchaTest {

	// captcha class object
	public static Captcha createCaptcha(int width, int height) {

		         Captcha cap = new Captcha.Builder(width, height)
				.addBackground(new SquigglesBackgroundProducer())//TransparentBackgroundProducer() FlactColorBackgroundProducer() GradiatedBackgroundProducer()
				.addText(new DefaultTextProducer())//FiveLetterFirstNameTextProducer() ArabicTextProducer() NumbersAnswerProducer()
				.addNoise(new StraightLineNoiseProducer())// CurvedLineNoiseProducer
				.build();
		         return cap;
}

	// convert into image
	public static void createImage(Captcha captcha) {

		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			//write(captcha.getImage(), "png", os);
			ImageIO.write(captcha.getImage(), "png", os);
			FileOutputStream fos = new FileOutputStream(
					"C:/Users/user-/Desktop/RaghuSirNareshITJavaPdfs/mycaptcha.png");
			fos.write(os.toByteArray());
			fos.flush();
			fos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Captcha captcha = createCaptcha(200, 80);
		createImage(captcha);
		System.out.println("Done");

	}

}

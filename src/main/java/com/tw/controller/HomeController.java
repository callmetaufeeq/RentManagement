package com.tw.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.tw.download.QRCodeGenerator;

@RestController
public class HomeController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

	@GetMapping("/qrcode")
	public String getQRCode(Model model) {
		String medium = "https://forms.gle/sr5V9efsPpgTwK8N7";
		String url = "https://forms.gle/sr5V9efsPpgTwK8N7";

		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRCodeGenerator.getQRCodeImage(medium, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			QRCodeGenerator.generateQRCodeImage(url, 250, 250, QR_CODE_IMAGE_PATH);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		// Convert Byte Array into Base64 Encode String
		String qrcode = Base64.getEncoder().encodeToString(image);

		//model.addAttribute("medium", medium);
		model.addAttribute("url", url);
		model.addAttribute("qrcode", qrcode);

		return "qrcode";
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

}

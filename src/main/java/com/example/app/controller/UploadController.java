package com.example.app.controller;

import java.io.File;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	//private static final String UPLOAD_DIRECTORY = "/home/trainee/uploads";

	@GetMapping("/")
	public String index() {
		return "redirect:/upload";
	}

	@GetMapping("/upload")
	public String uploadGet(Model model) {
		return "upload";
	}

	@PostMapping("/upload")
	public String post(
			@RequestParam MultipartFile upfile, 
			Model model) throws Exception {
		if (!upfile.isEmpty()) {
			// 元のファイル名を取得
			String fileName = upfile.getOriginalFilename();
			// uploadsフォルダに保存
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String directory = bundle.getString("upload.directory");
			File dest = new File(directory + fileName);
			upfile.transferTo(dest);
			// 完了画面の表示
			return "uploadDone";
		} else {
			// ファイル未選択：リダイレクトにより、Getリクエストにする
			return "redirect:/upload";
		}
	}
}

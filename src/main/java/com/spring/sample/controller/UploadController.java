package com.spring.sample.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> index(@RequestParam("filedata") MultipartFile multipartfile, HttpServletRequest request) {
		String fileurl = "";
		if (multipartfile != null) {
			
			File file = null;
			try {
				file = new File(multipartfile.getOriginalFilename()); 
				file.createNewFile();
				multipartfile.transferTo(file);
				file.renameTo(new File(request.getSession().getServletContext().getRealPath("/images/" + file.getName())));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			fileurl = file.getName(); 
		}
		
		return new ResponseEntity<String>(fileurl, HttpStatus.OK);
	}
}

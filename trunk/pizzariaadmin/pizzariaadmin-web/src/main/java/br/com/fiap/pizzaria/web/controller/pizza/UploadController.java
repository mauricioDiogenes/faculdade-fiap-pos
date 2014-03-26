package br.com.fiap.pizzaria.web.controller.pizza;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("image")
public class UploadController {
	
	@RequestMapping( value = "cadastro", method=RequestMethod.GET)
	public String init(){
		return "cadastro";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public @ResponseBody String upload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		byte[] encodeBase64 = Base64.encodeBase64(multipartFile.getBytes());
		return new String(encodeBase64);
	}

}

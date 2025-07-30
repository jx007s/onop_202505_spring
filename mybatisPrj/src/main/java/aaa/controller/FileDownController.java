package aaa.controller;



import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/fileDown/{fileName}")
public class FileDownController {

	@RequestMapping
	ResponseEntity<Resource> qwer(@PathVariable("fileName")String fileName, 
			HttpServletRequest request) throws Exception{
		//파일 저장
		String dirPath = request.getServletContext().getRealPath("fff")+"\\";
		dirPath = "D:\\public\\onop\\onop2025_05\\public\\study\\spring_work\\mybatisPrj\\src\\main\\resources\\static\\fff\\";
		
		Path fPath = Paths.get(dirPath+fileName).normalize();
		
		Resource source = new UrlResource(fPath.toUri());
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(source);
	}
}

package aaa.controller;



import java.io.FileInputStream;
import java.net.URLEncoder;
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

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/fileDown/{fileName}")
public class FileDownController {

	//@RequestMapping
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
	
	
	@RequestMapping
	void doGet(@PathVariable("fileName")String fileName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//다운로드로 변경
		
		
		String enName = URLEncoder.encode(fileName,"UTF-8");
		
		//1. 다운로드로 변경
		response.setHeader("Content-Disposition", "attachment;filename="+enName);
		
		//파일 저장 위치
		String dirPath = request.getServletContext().getRealPath("fff")+"\\";
		dirPath = "D:\\public\\onop\\onop2025_05\\public\\study\\spring_work\\mybatisPrj\\src\\main\\resources\\static\\fff\\";
		
		//2. 파일 읽기
		FileInputStream fis = new FileInputStream(dirPath+fileName);
		
		//3. 파일 쓰기
		ServletOutputStream sos = response.getOutputStream();
		
		//4. 파일 내용전송
		byte [] buf = new byte[1024];
		
		while(fis.available()>0) {
			int len = fis.read(buf);
			sos.write(buf,0,len);
		}
		
		
		//5. 스트림 종료
		sos.close();
		fis.close();
	}
	
	
	
}

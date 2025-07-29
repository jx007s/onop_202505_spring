package aaa.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {

	Integer id,gid, seq, lev, cnt;
    String title,content, pname, pw, upfile;
    Date regDate;
    
    MultipartFile upFF;
    
    public String getContentBr() {
		return content.replaceAll("\n", "<br/>");
	}
}

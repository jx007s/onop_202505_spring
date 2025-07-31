package aaa.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDTO {

	Integer id,gid, seq, lev, cnt;
    String title,content, pname, pw, upfile;
    Date regDate;
    
    MultipartFile upFF;
    
    
    
    
    public String getUpfile() {
    		if(upfile !=null && upfile.trim().equals("")) {
    			upfile = null;
    		}
		return upfile;
	}
    
    public boolean isImg() {
		
		if(getUpfile() == null) {
			return false;
		}
		
		String nowExt = upfile.toLowerCase().substring(upfile.lastIndexOf(".")+1);
		
		ArrayList<String> imgExts = new ArrayList<String>();
		for(String ext: "jpg,jpeg,bmp,gif,png".split(",")) {
			imgExts.add(ext);
		}
		
		return imgExts.contains(nowExt);
	}



	public String getContentBr() {
		return content.replaceAll("\n", "<br/>");
	}

	public BoardDTO(String title, String pname, String content, String pw) {
		super();
		this.title = title;
		this.pname = pname;
		this.content = content;
		this.pw = pw;
	}
}

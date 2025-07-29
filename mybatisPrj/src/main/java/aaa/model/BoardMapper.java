package aaa.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {

	@Select("select * from board")
	List<BoardDTO> list();
	
	
	@Select("select * from board where id = #{id}")
	BoardDTO detail(int id);
	
	@Insert("insert into board "+
			"(title, pname, content, pw, upfile, reg_date) values "+
			"(#{title}, #{pname}, #{content}, #{pw}, #{upfile}, now() )"
			)
	int insert(BoardDTO dto);
}

package aaa.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

	@Select("select * from board")
	List<BoardDTO> list();
	
	@Select("select * from board  order by gid desc, seq limit #{start}, #{cnt}")
	List<BoardDTO> list2(PageInfo pInfo);
	
	@Select("select count(*) from board")
	int totalCnt();
	
	
	@Select("select * from board where id = #{id}")
	BoardDTO detail(int id);
	
	@Insert("insert into board "+
			"(title, pname, content, pw, upfile, reg_date) values "+
			"(#{title}, #{pname}, #{content}, #{pw}, #{upfile}, now() )"
			)
	int insert(BoardDTO dto);
	
	@Delete("delete from board where id = #{id} and pw = #{pw}")
	int delete(BoardDTO dto);
	
	@Update("update board set pname = #{pname}, title= #{title}, content = #{content} "+
	        " where id = #{id} and pw = #{pw} ")
	int modify(BoardDTO dto);
}

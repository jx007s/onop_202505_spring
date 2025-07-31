package aaa.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DynamicMapper {

	@Select(
			"<script> "
			+"select * from board "
			
			+ "<where>"
			
			+ " <if test='pname != null'> "
			+ " pname like concat('%',#{pname},'%')  "
			+ " </if> "
			
			+ " <if test='regDate != null'> "
			+ " and reg_date >= #{regDate} "
			+ " </if> "
			
			+ "</where>"
			
			+ " </script>"
			)
	List<BoardDTO> list1(BoardDTO dto);
	
	
	@Select("select * from board where id = #{id}")
	BoardDTO detail(int id);
	
	@SelectKey(
			keyProperty = "id",
			resultType = Integer.class,
			before = true,
			statement = "select max(id)+1 from board"
			)
	@Insert("insert into board "+
			"(  id,  gid,   title, pname, content, pw, upfile, reg_date) values "+
			"(#{id},#{id}, #{title}, #{pname}, #{content}, #{pw}, #{upfile}, now() )"
			)
	int insert(BoardDTO dto);
	
	
	@SelectKey(
			keyProperty = "id",
			resultType = Integer.class,
			before = false,
			statement = "select max(id) from board"
			)
	@Insert("insert into board "+
			"(  seq,   lev,  gid,   title, pname, content, pw, upfile, reg_date) values "+
			"(#{seq},#{lev},#{gid}, #{title}, #{pname}, #{content}, #{pw}, #{upfile}, now() )"
			)
	int reply(BoardDTO dto);
	
	
	@Select("<script> "
			+" select  "
			+"<choose> "
			+   "<when test='chk = 1 '>"
			+	 "kor"
			+   "</when>"
			+"</choose> "
			+" from exam "
			+" </script>"
			)
	List<ExamDTO>exam();
	
	
	
	
	@Delete("delete from board where id = #{id} and pw = #{pw}")
	int delete(BoardDTO dto);
	
	@Update("update board set pname = #{pname}, title= #{title}, content = #{content} "+
	        " where id = #{id} and pw = #{pw} ")
	int modify(BoardDTO dto);
}

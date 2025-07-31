package aaa.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

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
			+   "<when test='chk == 1'>"
			+	 "kor"
			+   "</when>"
			+   "<when test='chk == 2'>"
			+	 "eng"
			+   "</when>"
			+   "<when test='chk == 3'>"
			+	 "mat"
			+   "</when>"
			+"</choose> "
			+" from exam "
			+" </script>"
			)
	List<ExamDTO>exam(ExamDTO dto);
	
	
	
	@Insert("insert into board "+
			"(  id,  gid, title, pname, content, pw,  reg_date) values "+
			"(  154, 154, '어흥', '진우',  '군대고','1111', now() )," +
			"(  155, 155, '야옹', '진미',  '군대고','1111', now() )," +
			"(  156, 156, '멍멍', '진양',  '군대고','1111', now() ) " 
			)
	int insertList1();
	
	
	@Insert(
			"<script> "+
			"insert into board "+
			"( title, pname, content, pw,  reg_date) values "+
			"<foreach collection='arr' item='dd' separator=',' index='i'>"+
			
				"( #{dd.title}, #{dd.pname}, #{dd.content}, #{dd.pw}, now() )" 
			
			+"</foreach>"
			+"</script> "
			)
	int insertList2(@Param("arr") ArrayList<BoardDTO> arr);
	
	
	
	
	@SelectKey(
			keyProperty = "maxid",
			resultType = Integer.class,
			before = true,
			statement = "select max(id)+1 from board"
			)
	@Insert(
			"<script> "+
			"insert into board "+
			"( id,  gid, title, pname, content, pw,  reg_date) values "+
			"<foreach collection='arr' item='dd' separator=',' index='i'>"+
			
				"( #{maxid}+#{i},#{maxid}+#{i}, #{dd.title}, #{dd.pname}, #{dd.content}, #{dd.pw}, now() )" 
			
			+"</foreach>"
			+"</script> "
			)
	int insertList3(BoardSSS bs);
}

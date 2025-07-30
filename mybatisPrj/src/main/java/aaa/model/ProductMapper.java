package aaa.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

	@Select("select * from product")
	List<ProductDTO> list();
	
	
	@Select("select * from product where id = #{id}")
	ProductDTO detail(int id);
	
	@Insert("insert into product "+
			"(title, pname, content, pw, upfile, reg_date) values "+
			"(#{title}, #{pname}, #{content}, #{pw}, #{upfile}, now() )"
			)
	int insert(ProductDTO dto);
	
	@Delete("delete from product where id = #{id} and pw = #{pw}")
	int delete(ProductDTO dto);
	
	@Update("update product set pname = #{pname}, title= #{title}, content = #{content} "+
	        " where id = #{id} and pw = #{pw} ")
	int modify(ProductDTO dto);
}

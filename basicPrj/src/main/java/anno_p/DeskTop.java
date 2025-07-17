package anno_p;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Resource;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
class BonChe{
	String name;
}
@Data
class Monitor{
	String name;
	int size;
}
@Data
class KeyBoard{
	String name, type;
}
@Data
class Mouse{
	String name;
	boolean wireless;
}

//본체 1, 마우스 1
@ToString
class Notebook{
	@Setter
	String name;
	@Autowired
	BonChe ysk;
	@Autowired
	Mouse mc;
}

//본체 1, 모니터 2, 키보드 1, 마우스 1
@ToString
public class DeskTop {
	@Setter
	String name;
	@Resource
	BonChe  king;
	@Resource
	Monitor mo1;
	@Resource
	Monitor mo2;
	@Resource
	KeyBoard kb;
	@Resource
	Mouse mc;
}

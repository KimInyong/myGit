package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 원래 이곳에서 VO, DAO를 초기화하고 원하는 작업 수행에 필요한
		// DAO 메서드를 호출 => 이결과로 얻어진 결과값을 page로 전달해야한다면
		// request.setAttribute(key, value);
		// ...
		//위와 같이 셋팅해야 합니다.
		// 가야할 페이지를 문자열 또는 아래와 같이 알려준다
		System.out.println("IndexAction의 execute() 수행됨!");
		return new ActionForward("index.jsp", false);
	}

}

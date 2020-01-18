package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// ���� �̰����� VO, DAO�� �ʱ�ȭ�ϰ� ���ϴ� �۾� ���࿡ �ʿ���
		// DAO �޼��带 ȣ�� => �̰���� ����� ������� page�� �����ؾ��Ѵٸ�
		// request.setAttribute(key, value);
		// ...
		//���� ���� �����ؾ� �մϴ�.
		// ������ �������� ���ڿ� �Ǵ� �Ʒ��� ���� �˷��ش�
		System.out.println("IndexAction�� execute() �����!");
		return new ActionForward("index.jsp", false);
	}

}

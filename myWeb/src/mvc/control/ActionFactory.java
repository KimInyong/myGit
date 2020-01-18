package mvc.control;

import mvc.action.Action;
import mvc.action.IndexAction;

public class ActionFactory { //팩토리 패턴
	// 인스턴스를 저장하기 위한 변수
	// 외부에서 직접 호출할 수 없도록 private으로 선언
	private static ActionFactory factory; //싱글톤 패턴
	
	//생성자도 private으로 선언하여 외부에서 호출할 수 없도록 함
	private ActionFactory() {}
	
	//클래스의 유일한 인스턴스를 반환하는 메서드
	public static synchronized ActionFactory getInstance() {
		//인스턴스가 존재하지 않는다면 생성
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("index")) {
			action = new IndexAction();
		}
		return action;
	}
}

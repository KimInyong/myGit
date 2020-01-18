package mvc.control;

import mvc.action.Action;
import mvc.action.IndexAction;

public class ActionFactory { //���丮 ����
	// �ν��Ͻ��� �����ϱ� ���� ����
	// �ܺο��� ���� ȣ���� �� ������ private���� ����
	private static ActionFactory factory; //�̱��� ����
	
	//�����ڵ� private���� �����Ͽ� �ܺο��� ȣ���� �� ������ ��
	private ActionFactory() {}
	
	//Ŭ������ ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	public static synchronized ActionFactory getInstance() {
		//�ν��Ͻ��� �������� �ʴ´ٸ� ����
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

package org.scut.mychart.service;

import java.util.Map;

public interface INetPointService {
	/**
	 * ��ȡ�ն�����ͳ��
	 * @return 
	 */
	public Map<String,Object> getTerminalAmount(String year, String p);
	
	/**
	 * ��ȡ���㹤��״̬ͳ��
	 * @return
	 */
	public Map<String,Object> getWorkState(String year, String p);
	
	/**
	 * ��ȡ����ҵ����
	 * @return
	 */
	public Map<String,Object> getOperationAmout(String year, String p);
}

package org.scut.mychart.service;

import java.util.Map;

public interface INetPointService {
	
	public Map<String,Object> getTerminalAmount(String year, String p);
	
	public Map<String,Object> getWorkState(String year, String p);
	
	public Map<String,Object> getOperationAmout(String year, String p);
}

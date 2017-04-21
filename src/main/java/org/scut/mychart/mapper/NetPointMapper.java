package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.NetPointModel;

public interface NetPointMapper {
	public List<NetPointModel> selectTerminalAmout(Map<String, Object> param);
	public int countTerminal(Map<String, Object> param);
	
	public List<NetPointModel> selectWorkState(Map<String, Object> param);
	public int countWorkState(Map<String, Object> param);
	
	public List<NetPointModel> selectOperationAmout(Map<String, Object> param);
	public int countOperation(Map<String, Object> param);
}

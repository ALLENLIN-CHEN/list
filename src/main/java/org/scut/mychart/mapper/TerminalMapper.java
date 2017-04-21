package org.scut.mychart.mapper;


import org.scut.mychart.model.TerminalModel;

import java.util.List;
import java.util.Map;

public interface TerminalMapper {
	public List<TerminalModel> selectTerminalType(Map<String, String> param);
	public List<TerminalModel> selectTerminalStatus(Map<String, String> param);
	public List<TerminalModel> selectTerminalBusiness(Map<String, String> param);
}	

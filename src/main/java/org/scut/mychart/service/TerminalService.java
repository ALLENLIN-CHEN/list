package org.scut.mychart.service;

import java.util.Map;

public interface TerminalService {
    public Map<String, Object> getTerminalType(String year, String p) ;
    public Map<String, Object> getTerminalStatus(String year, String p) ;
    public Map<String, Object> getTerminalBusiness(String year, String p) ;
}

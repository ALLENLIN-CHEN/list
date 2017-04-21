package org.scut.mychart.service;

import java.util.Map;

/**
 * 获取异地就医的相关数据
 * @author spiden
 *
 */

public interface OtherHosService {
	
	/**
	 * 获取柱状图数据
	 * @return
	 */
	
	public Map<String,Object> getHistogramData();
	
	
	/**	
	 * 获取折线图数据
	 * @return
	 */
	public Map<String, Object> getLineData();
	
	
	/**
	 * 获取仪表盘数据
	 * @return
	 */
	public Map<String, Object> getPanelData();
	
	/**
	 * 获取漏斗图数据
	 * @return
	 */
	public Map<String, Object> getFunnelData();
	
	/**
	 *获取柱状图数据 按医院
	 * @return
	 */
	public Map<String, Object> getHistogramData_hos(String year,String p); 
	
	/**
	 * 获取柱状图数据 按部门
	 * @return
	 */
	public Map<String, Object> getHistogramData_dep(String year,String p);
	
	/**
	 * 获取柱状图数据  医院占比
	 * @return
	 */
	public Map<String, Object> getHistogramData_hosPercent(String sTime, String eTime,String p);
	
	/**获取柱状图数据  科室占比
	 * @return
	 */
	public Map<String, Object> getHistogramData_depPercent(String sTime, String eTime,String p);

}

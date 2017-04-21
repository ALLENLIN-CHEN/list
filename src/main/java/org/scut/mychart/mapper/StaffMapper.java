package org.scut.mychart.mapper;

import java.util.List;


import org.scut.mychart.model.StaffModel;

/**
 * 人员流动 mapper
 * @author spiden
 *
 */
public interface StaffMapper {
	
	/**
	 * @param stime
	 * @param etime
	 * 获取流入人员
	 * @return
	 */
	public List<StaffModel> selectIn(String stime,String etime);
	
	
	/**
	 * @param stime
	 * @param etime
	 * 获取流出人员
	 * @return
	 */
	public List<StaffModel> selectOut(String stime,String etime);
	
	/**
	 * @return
	 * 获取所有年份的流入人员
	 */
	public List<StaffModel> selectInAll();
	
	/**
	 * @return
	 * 获取所有年份的流出人员
	 */
	public List<StaffModel> selectOutAll();
	
	
	/**
	 * @param stime
	 * @param etime
	 * 获取城市间的流动关系
	 * @return
	 */
	public List<StaffModel> selectRelationship(String stime,String etime);
	public List<StaffModel> selectRelationshipPlus(String stime,String etime);

}

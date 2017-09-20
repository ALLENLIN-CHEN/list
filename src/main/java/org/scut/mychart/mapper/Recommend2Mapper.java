package org.scut.mychart.mapper;

import org.scut.mychart.model.Recommend2ResultModel;
import org.scut.mychart.model.UserModel;
import org.scut.mychart.model.UserStructModel;

import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
public interface Recommend2Mapper {
	List<Recommend2ResultModel> selectRecommendResult(Map<String, String> param);
	List<Recommend2ResultModel> selectRecommend2Rating(Map<String, String> param);
	List<UserStructModel> selectRecommenduser(Map<String, String> param);
	List<UserModel> selectuser(Map<String, String> param);
	List<UserStructModel> selectAlluser();
	List<Recommend2ResultModel> selectPlaceInfo();
	List<Recommend2ResultModel> selectExInfo();
	

	List<String> selectAllPersons();
}	


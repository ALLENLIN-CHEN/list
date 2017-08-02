package org.scut.mychart.mapper;

import org.scut.mychart.model.Recommend2ResultModel;

import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
public interface Recommend2Mapper {
	List<Recommend2ResultModel> selectRecommendResult(Map<String, String> param);
	List<Recommend2ResultModel> selectRecommend2Rating(Map<String, String> param);
	List<Recommend2ResultModel> selectPlaceInfo();
	List<Recommend2ResultModel> selectExInfo();
	

	List<String> selectAllPersons();
}	


package org.scut.mychart.service.impl;

import org.scut.mychart.mapper.Recommend2Mapper;
import org.scut.mychart.model.Recommend2ResultModel;
import org.scut.mychart.model.UserModel;
import org.scut.mychart.model.UserStructModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author gzw
 */
@Service("recommend2Service")

public class Recommend2ServiceImpl {
    @Resource  
    private Recommend2Mapper recommendDao;

    public List<Recommend2ResultModel> getRecommendResult(String id){
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
    	return recommendDao.selectRecommendResult(param);
    }

    public Map<String, Object> getResult(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("id", id);
//    	List<RecommendResultModel> resultModels  =new ArrayList<>();
		List<Recommend2ResultModel> rating = recommendDao.selectRecommend2Rating(param);
		if (rating.size()==0) {
			List<UserStructModel> userid = recommendDao.selectRecommenduser(param);
			List<UserModel>userinformation=recommendDao.selectuser(param);
			List<UserStructModel> alluser = recommendDao.selectAlluser();

			if (userid.size() == 0) {
				System.out.println("sfasf");

			} else {
				Integer i, j, temp = -1;
				/*if (userid.get(0).getCategory() == "保洁")
					userid.get(0).setCategory("1");
				else if (userid.get(0).getCategory() == "保健")
					userid.get(0).setCategory("2");
				else if (userid.get(0).getCategory() == "保安")
					userid.get(0).setCategory("3");
				else if (userid.get(0).getCategory() == "农林")
					userid.get(0).setCategory("4");
				else if (userid.get(0).getCategory() == "工人")
					userid.get(0).setCategory("5");
				else if (userid.get(0).getCategory() == "快递")
					userid.get(0).setCategory("6");
				else if (userid.get(0).getCategory() == "汽修")
					userid.get(0).setCategory("7");
				else if (userid.get(0).getCategory() == "美发")
					userid.get(0).setCategory("8");
				else if (userid.get(0).getCategory() == "超市")
					userid.get(0).setCategory("9");
				else if (userid.get(0).getCategory() == "餐饮")
					userid.get(0).setCategory("10");
				else
					userid.get(0).setCategory("11");
				System.out.println(userid.get(0).getCategory())
				for (i = 0; i < alluser.size(); i++) {
					if (alluser.get(i).getCategory() == "保洁")
						alluser.get(i).setCategory("1");
					else if (alluser.get(i).getCategory() == "保健")
						alluser.get(i).setCategory("2");
					else if (alluser.get(i).getCategory() == "保安")
						alluser.get(i).setCategory("3");
					else if (alluser.get(i).getCategory() == "农林")
						alluser.get(i).setCategory("4");
					else if (alluser.get(i).getCategory() == "工人")
						alluser.get(i).setCategory("5");
					else if (alluser.get(i).getCategory() == "快递")
						alluser.get(i).setCategory("6");
					else if (alluser.get(i).getCategory() == "汽修")
						alluser.get(i).setCategory("7");
					else if (alluser.get(i).getCategory() == "美发")
						alluser.get(i).setCategory("8");
					else if (alluser.get(i).getCategory() == "超市")
						alluser.get(i).setCategory("9");
					else if (alluser.get(i).getCategory() == "餐饮")
						alluser.get(i).setCategory("10");
					else
						alluser.get(i).setCategory("11");
				}*/
				Integer minid = temp;
				double minlen = 9999999;
				uservector v2 = new uservector(Integer.parseInt(userid.get(0).getSex()),
						Integer.parseInt(userid.get(0).getAge()),
						Integer.parseInt(userid.get(0).getSalary()),
						Integer.parseInt(userid.get(0).getWorkyear()),
						Integer.parseInt(userid.get(0).getEducation()));
				for (i = 0; i < alluser.size(); i++) {
					if (temp != -1 && temp == i) continue;
					if (!alluser.get(i).getCategory().equals(userid.get(0).getCategory())) continue;
					uservector v1 = new uservector(Integer.parseInt(alluser.get(i).getSex()),
							Integer.parseInt(alluser.get(i).getAge()),
							Integer.parseInt(alluser.get(i).getSalary()),
							Integer.parseInt(alluser.get(i).getWorkyear()),
							Integer.parseInt(alluser.get(i).getEducation()));
					double cossim = v2.cosinesim(v1);
					if (cossim < minlen) {
						minlen = cossim;
						minid = Integer.parseInt(alluser.get(i).getId());
					}
				}
				System.out.println(minid);
				if (minid == -1) {
					//tankuang
				} else {
					param.put("id", minid.toString());
					rating = recommendDao.selectRecommend2Rating(param);

					for( i=0;i<rating.size();i++) {
						rating.get(i).setName(userinformation.get(0).getName());
						rating.get(i).setAge(userinformation.get(0).getAge());
						rating.get(i).setArea(userinformation.get(0).getArea());
						rating.get(i).setSex(userinformation.get(0).getSex());
						rating.get(i).setTarget_job(userinformation.get(0).getTarget_job());
						rating.get(i).setWorkyear(userinformation.get(0).getWorkyear());
						rating.get(i).setSalary(userinformation.get(0).getSalary());
						rating.get(i).setEducation(userinformation.get(0).getEducation());
					}

				}
			}

		}

		int total_size = rating.size();
		System.out.println(total_size);


		for (int i = 0; i < total_size; i++) {


			if (rating.get(i).getSex() == "1") {
				rating.get(i).setSex("男性");
			} else {
				rating.get(i).setSex("女性");
			}


		}

//    	System.out.println('1');
//    	for(int j=1;j<place_size;j++){		
//			System.out.println('2');
//			System.out.println(place.get(j).getEx_id().trim());
//    		System.out.println(place.get(j).getEx_name());
//    	
//		}


		result.put("data", rating);
		return result;

	}

    public List<String> getAllPersons(){
        return recommendDao.selectAllPersons();

    }
}


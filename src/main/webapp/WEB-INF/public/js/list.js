var classData = {
		card: [{   
		    	   key: 'register',
		    	   value: '挂号业务'
		       },
			   {
				   key: 'hos_2',
				   value: '就医服务'
			   },
		       {
		    	   key: 'external',
		    	   value: '异地就医业务'
		       },
		       {   
		    	   key: 'special',
		    	   value: '特殊医疗业务'
		       },
			   {
				   key: 'expense',
				   value: '医疗费用报销申请业务'
			   },
		       {
		    	   key:'other',
		    	   value: '住院登记'
			   },
			   {
				   key: 'clinic',
				   value: '门诊统筹业务'			   
		       
		}],
		enterprise: [{
			key: 'companyType',
			value: '单位类型参保业务'
		},
			{
				key: 'industryType',
				value: '行业类型参保业务'
			},{
				key: 'financialType',
				value: '经济类型参保业务'
			}
		],

		staff:[
			{
				key:'totalData',
				value:'全部流入流出统计'
					
			},
			{
				key:'partData',
				value:'经济发达地区统计'
			}
			
		],

		cardTotal:[{
			key:'netpoint',
			value:'社保终端网点分析'
		    },
			{
				key:'cardFunction',
				value:'用户常用卡功能分析'
			}
		]

};

var moduleData = {
		register: [{
			url: 'charts/register/hospitalTotal',
			key: 'year',
			list: 'registerHospYear',
			value: '医院排名'
		},{
			url: 'charts/register/hospitalPercent',
			key: 'time',
			list: 'registerHospTime',
			value: '医院占比排名'
		},{
			url: 'charts/register/departmentTotal',
			key: 'year',
			list: 'registerDepYear',
			value: '科室排名'
		},{
			url: 'charts/register/departmentPercent',
			key: 'time',
			list: 'registerDepTime',
			value: '科室占比排名'
		},{
			url: 'charts/register/docotorTotal',
			key: 'year',
			list: 'registerDocYear',
			value: '医生排名'
		},{
			url: 'charts/register/docotorPercent',
			key: 'time',
			list: 'registerDocTime',
			value: '医生占比排名'
		}],

		external: [{
		url: 'charts/externalList/hospitalTotal',
		key: 'year',
		list: 'externalHospYear',
		value: '医院排名'
	},{
		url: 'charts/externalList/hospitalPercent',
		key: 'time',
		list: 'externalHospTime',
		value: '医院占比排名'
	},{
		url: 'charts/externalList/departmentTotal',
		key: 'year',
		list: 'externalDepYear',
		value: '科室排名'
	},{
		url: 'charts/externalList/departmentPercent',
		key: 'time',
		list: 'externalDepTime',
		value: '科室占比排名'
	},{
		url: 'charts/externalList/doctorTotal',
		key: 'year',
		list: 'externalDocYear',
		value: '医生排名'
	},{
		url: 'charts/externalList/doctorPercent',
		key: 'time',
		list: 'externalDocTime',
		value: '医生占比排名'
	}],

        hos_2: [{
			url: 'charts/hos_2/hospitalTotal',
    		key: 'year',
			list: 'hos_2HospYear',
			value: '医院排名'
		},{
			url: 'charts/hos_2/hospitalPercent',
			key: 'time',
			list: 'hos_2HospTime',
			value: '医院占比排名'
		},{
			url: 'charts/hos_2/departmentTotal',
			key: 'year',
			list: 'hos_2DepYear',
			value: '科室排名'
		},{
			url: 'charts/hos_2/departmentPercent',
			key: 'time',
			list: 'hos_2DepTime',
			value: '科室占比排名'
		},{
			url: 'charts/hos_2/doctorTotal',
			key: 'year',
			list: 'hos_2DocYear',
			value: '医生排名'
		},{
			url: 'charts/hos_2/doctorPercent',
			key: 'time',
			list: 'hos_2DocTime',
			value: '医生占比排名'
		}],

		special: [{
		url: 'charts/special/hospitalTotal',
		key: 'year',
		list: 'specialHospYear',
		value: '医院排名'
	},{
		url: 'charts/special/hospitalPercent',
		key: 'time',
		list: 'specialHospTime',
		value: '医院占比排名'
	},{
		url: 'charts/special/departmentTotal',
		key: 'year',
		list: 'specialDepYear',
		value: '科室排名'
	},{
		url: 'charts/special/departmentPercent',
		key: 'time',
		list: 'specialDepTime',
		value: '科室占比排名'
	    }],

		expense: [{
			url: 'charts/expense/hospitalTotal',
			key: 'year',
			list: 'expenseHospYear',
			value: '医院排名'
		},{
			url: 'charts/expense/hospitalPercent',
			key: 'time',
			list: 'expenseHospTime',
			value: '医院占比排名'
		},{
			url: 'charts/expense/departmentTotal',
			key: 'year',
			list: 'expenseDepYear',
			value: '科室排名'
		},{
			url: 'charts/expense/departmentPercent',
			key: 'time',
			list: 'expenseDepTime',
			value: '科室占比排名'
		}],

		other: [{
			url: 'charts/other/otherGetHisHospital',
			key: 'year',
			list: 'otherHosYear',
			value: '医院排名'
		},{
			url: 'charts/other/otherGetHisHosPercent',
			key: 'time',
			list: 'otherHosTime',
			value: '医院占比排名'
		},{
			url: 'charts/other/otherGetHisDepartment',
			key: 'year',
			list: 'otherDepYear',
			value: '科室排名'
		},{
			url: 'charts/other/otherGetHisDepPercent',
			key: 'time',
			list: 'otherDepTime',
			value: '科室占比排名'
		}],
		
		totalData:[
			{
				url:'staff/staffAllData',
				key:'time',
				list:'allData',
				value:'同一城市流入流出情况'
			}
			
		],
	
		clinic:[{
		        	url: 'charts/clinic/hospitalTotal',
		        	key: 'year',
		        	list: 'clinicHospYear',
		        	value: '医院排名'
		        },
		        {
		        	url: 'charts/clinic/departmentTotal',
		        	key: 'year',
		        	list: 'clinicDepYear',
		        	value: '科室排名'
		        },
		        {
		        	url:'charts/clinic/doctorTotal',
		        	key:'year',
		        	list:'clinicDocYear',
		        	value:'医生排名'
		        }],
				
		companyType: [{
			url: 'charts/company/data',
			key: 'year',
			list: 'enterpriseCompanyType',
			value: '单位类型参保基数分析'
		}],
		
		industryType:[{
				url: 'charts/industry/data',
				key: 'year',
				list: 'enterpriseIndustryType',
				value: '行业类型参保基数分析'
		}],

	    financialType:[{
		    url: 'charts/base_3/data',
	    	key: 'year',
	    	list: 'enterpriseFinancialType',
	    	value: '经济类型参保基数分析'
	    }],
	    
	    netpoint:[{
        	url: 'charts/netpoint/getWorkState',
        	key: 'year',
        	list: 'npState',
        	value: '网点状态统计'
        },
        {
        	url: 'charts/netpoint/getOperationAmount',
        	key: 'year',
        	list: 'npOperation',
        	value: '网点业务量'
        },
        {
        	url:'charts/netpoint/getTerminalAmount',
        	key:'year',
        	list:'npTerminal',
        	value:'网点终端数量'
        },
			{
				url: 'charts/terminal/getTypeData',
				key: 'year',
				list: 'terminalType',
				value: '终端类型数量'
			},
			{
				url: 'charts/terminal/getBusinessData',
				key: 'year',
				list: 'terminalBusiness',
				value: '终端业务量'
			},
			{
				url: 'charts/terminal/getStatusData',
				key: 'year',
				list: 'terminalStatus',
				value: '终端工作状态'
			}
		],

	cardFunction:[
		{
			url: 'charts/card_3_2/card_3_2_1list',
			key: 'year',
			list: 'cardPrimaryType',
			value: '全市社保卡应用情况'
	    },
		{
			url: 'charts/card_3_2/card_3_2_2list',
			key: 'year',
			list: 'cardDetailType',
			value: '社保102项应用情况'
		},
		]
};

var filterData = {
	year: ['year-choice'],
	time: ['time-choice']
};

//用于构造列表的相对应表头数据
var listThead = {
	registerHospYear: ['医院名称', '年总挂号数量'],
	registerHospTime: ['医院名称', '年总挂号数量占比'],
	registerDepYear: ['医院名称', '科室名称', '年总挂号数量'],
	registerDepTime: ['医院名称', '科室名称', '年总挂号数量占比'],
	registerDocYear: ['医院名称', '科室名称', '医生名称', '年总挂号数量'],
	registerDocTime: ['医院名称', '科室名称', '医生名称', '年总挂号数量占比'],

	externalHospYear: ['医院名称', '年总挂号数量'],
	externalHospTime: ['医院名称', '年总挂号数量占比'],
	externalDepYear: ['医院名称', '科室名称', '年总挂号数量'],
	externalDepTime: ['医院名称', '科室名称', '年总挂号数量占比'],
	externalDocYear: ['医院名称', '科室名称', '医生名称', '年总挂号数量'],
	externalDocTime: ['医院名称', '科室名称', '医生名称', '年总挂号数量占比'],

    hos_2HospYear: ['医院名称', '年总挂号数量'],
    hos_2HospTime: ['医院名称', '年总挂号数量占比'],
    hos_2DepYear: ['医院名称', '科室名称', '年总挂号数量'],
    hos_2DepTime: ['医院名称', '科室名称', '年总挂号数量占比'],
    hos_2DocYear: ['医院名称', '科室名称', '医生名称', '年总挂号数量'],
    hos_2DocTime: ['医院名称', '科室名称', '医生名称', '年总挂号数量占比'],

	enterpriseCompanyType: ['单位类型名称', '单位类型参保基数'],

	specialHospYear: ['医院名称', '年总特殊医疗数量'],
	specialHospTime: ['医院名称', '年总特殊医疗数量占比'],
	specialDepYear: ['医院名称', '科室名称', '年总特殊医疗数量'],
	specialDepTime: ['医院名称', '科室名称', '年总特殊医疗数量占比'],

	expenseHospYear: ['医院名称', '年总医疗费用报销申请数量'],
	expenseHospTime: ['医院名称', '年总医疗费用报销申请数量占比'],
	expenseDepYear: ['医院名称', '科室名称', '年总医疗费用报销数量'],
	expenseDepTime: ['医院名称', '科室名称', '年总医疗费用报销数量占比'],


	otherHosYear: ['医院名称', '年总住院登记数量'],
	otherHosTime: ['医院名称', '年总住院登记数量占比'],
	otherDepYear: ['医院名称', '科室名称', '年总住院登记数量'],
	otherDepTime: ['医院名称', '科室名称', '年总住院登记数量占比'],
	
	allData:['城市','流出人次','流入人次','流入流出率'],

	clinicHospYear: ['医院名称', '年总门诊统筹申请数量'],
	clinicDepYear: ['医院名称', '科室名称', '年总门诊统筹申请数量'],
	clinicDocYear: ['医院名称', '科室名称', '医生名称', '年总门诊统筹申请数量'],	
	
	enterpriseIndustryType: ['行业名称', '行业参保基数'],

	enterpriseFinancialType: ['经济类型名称', '经济类型参保基数'],

	npState:['网点名称','网点地址','正常工作天数','异常工作天数'],
	npOperation:['网点名称','网点地址','业务量'],
	npTerminal:['网点名称','网点地址','终端数量'],

	terminalType:['终端类型','终端数量'],
	terminalBusiness:['终端编号','终端类型','所属网点','终端业务量'],
	terminalStatus:['终端编号','终端类型','所属网点','正常工作天数','异常工作天数'],

	cardPrimaryType:['应用名称/业务名称','用卡次数'],
	cardDetailType:['社保102项应用名称','用卡次数']
};

var curP = 1, totalP = 1;
hideLoading();
$(function() {
	$('.business-label').on('click', function() {
		$('.business-select').slideToggle('normal');
		$('.class-select').hide();
		$('.module-select').hide();
		$('.filter-wrapper').hide();
	});
	
	$('.business-select li').on('click', function() {
		var type = $(this).data('type');
		$('.business-label label').html($(this).html());
		$('.business-select').slideToggle('normal');
		setClassContent(type);
		$('.class-select').slideToggle('normal');
	});

	$('.class-label').on('click', function() {
		if($('.class-select ul li').length > 0) {
			$('.business-select').hide();
			$('.module-select').hide();
			$('.filter-wrapper').hide();
			$('.class-select').slideToggle('normal');
		}
	});
	
	$(document).on('click', '.class-select li', function() {
		var cls = $(this).data('class');
		$('.class-label label').html($(this).html());
		$('.class-select').slideToggle('normal');
		setModuleContent(cls);
		$('.module-select').slideToggle('normal');
	});

	$('.module-label').on('click', function() {
		if($('.module-select ul li').length > 0) {
			$('.business-select').hide();
			$('.class-select').hide();
			$('.filter-wrapper').hide();
			$('.module-select').slideToggle('normal');
		}
	});
	
	$(document).on('click', '.module-select li', function() {

		var url = $(this).data('url');
		var filter = $(this).data('filter');
		$('.module-label label').data('url', url);
		$('.module-label label').data('list', $(this).data('list'));
		$('.module-label label').html($(this).html());
		$('.module-select').slideToggle('normal');
		setFilterContent(filter);
		$('.filter-wrapper').data('filter', filter);
		$('.filter-wrapper').slideToggle('normal');
		//重置当前页数
		curP = 1;
	});
	
	$('.search-label').on('click', function() {
		if($('.module-label label').data('url')) {
			$('.business-select').hide();
			$('.class-select').hide();
			$('.module-select').hide();
			$('.filter-wrapper').slideToggle('normal');
		}
	});
	
	$('.search-btn').on('click', function() {
		showLoading();
		curP = 1;
		getData();
	});
	
	//绑定分页切换
	$(document).on('click', '.pagination li', function() {
		var self = $(this);
		if(!self.hasClass('active') && !self.hasClass('disabled')) {
			if(self.hasClass('prev')) {
				curP--;
			} else if(self.hasClass('next')) {
				curP++;
			} else {
				if(!self.find('a').hasClass('dotted')) {
					curP = self.find('a').html() - 0;
				}
			}
			getData();
		}
	});
});

function getData() {
	var filter = $('.filter-wrapper').data('filter');
	var param = {};
	param.p = curP+'';
	param.url = $('.module-label label').data('url');
	if(filter === 'year') {
		param.year = $('input[name="year"]:checked').val();
	} else if(filter === 'time') {
		param.startTime = $('.startTime').val();
		param.endTime = $('.endTime').val();
		
		if(parseInt(param.startTime, 10) > parseInt(param.endTime, 10)) {
			alert('开始时间不能大于结束时间！');
			return;
		}
	}
	
	$.ajax({
		type: 'POST',
		dataType: 'json',
		async: true,
		url: param.url,
		data: param,
		success: function(res) {
			handleData(res);
			hideLoading();
		},
		error: function(err) {
			alert('Error: ' + JSON.stringify(err));
			hideLoading();
		}                                                                                                                                                                                                                                                  
	});
}

function setClassContent(type) {
	$('.class-select ul').html('');
	var lis = [];
	for(var i = 0; i < classData[type].length; i++) {
		lis.push('<li class="animate" data-class="' + classData[type][i].key + '">' + classData[type][i].value + '</li>');
	}
	
	$('.class-select ul').html(lis.join(''));
}

function setModuleContent(type) {
	$('.module-select ul').html('');
	var lis = [];
	for(var i = 0; i < moduleData[type].length; i++) {
		lis.push('<li class="animate" data-url="' + moduleData[type][i].url + '" data-filter="'+ moduleData[type][i].key +'" data-list="'+moduleData[type][i].list+'">' + moduleData[type][i].value + '</li>');
	}
	
	$('.module-select ul').html(lis.join(''));
}

function setFilterContent(filter) {
	var choices = filterData[filter];
	$('.com-choice').hide();
	for(var i = 0; i < choices.length; i++) {
		$('.'+choices[i]).show();
	}
	
	if(filter === 'year') {
		$('input[name="year"]:first').prop('checked', true);
	} else if(filter === 'time') {
		$('.startTime').val('2010');
		$('.endTime').val('2010');
	}
}

function renderPages(curPage, totalPage) {
    var liArr = [];

    var index = 0;

    if(totalPage <= 1) {
    	liArr.push('<li class="disabled"><a href="javascript:;">&laquo;</a></li>');
        liArr.push('<li class="active"><a href="javascript:;">1</a></li>');
        liArr.push('<li class="disabled"><a href="javascript:;">&raquo;</a></li>');
        return liArr;
    }

    if(curPage == 1) {
        liArr.push('<li class="disabled"><a href="javascript:;">&laquo;</a></li>');
        liArr.push('<li class="active"><a href="javascript:;">1</a></li>');
    }else {
        liArr.push('<li class="prev"><a href="javascript:;">&laquo;</a></li>');
        liArr.push('<li><a href="javascript:;">1</a></li>');
    }

    if(totalPage <= 5) {
        for(index = 2; index <= totalPage; index++) {
            if(curPage === index) {
                liArr.push('<li class="active"><a href="javascript:;">'+index+'</a></li>');
            } else {
                liArr.push('<li><a href="javascript:;">'+index+'</a></li>');
            }

            if(index === totalPage) {
                if(curPage === totalPage) {
                    liArr.push('<li class="disabled"><a href="javascript:;">&raquo;</a></li>');
                } else {
                    liArr.push('<li class="next"><a href="javascript:;">&raquo;</a></li>');
                }
            }
        }

        return liArr;
    }

    if(curPage <= 3) {
        for(index = 2; index <= 3; index++) {
            if(curPage === index) {
                liArr.push('<li class="active"><a href="javascript:;">'+index+'</a></li>');
            } else {
                liArr.push('<li><a href="javascript:;">'+index+'</a></li>');
            }
        }

        liArr.push('<li><a class="dotted" href="javascript:;">...</a></li>');

        liArr.push('<li><a href="javascript:;">'+totalPage+'</a></li>');
        liArr.push('<li class="next"><a href="javascript:;">&raquo;</a></li>');

        return liArr;
    }

    if(totalPage - curPage < 3) {
        liArr.push('<li><a class="dotted" href="javascript:;">...</a></li>');
        for(index = totalPage - 2; index <= totalPage; index++) {
            if(curPage === index) {
                liArr.push('<li class="active"><a href="javascript:;">'+index+'</a></li>');
            } else {
                liArr.push('<li><a href="javascript:;">'+index+'</a></li>');
            }
        }

        if(totalPage === curPage) {
            liArr.push('<li class="disabled"><a href="javascript:;">&raquo;</a></li>');
        } else {
            liArr.push('<li class="next"><a href="javascript:;">&raquo;</a></li>');
        }

        return liArr;
    }

    liArr.push('<li><a class="dotted" href="javascript:;">...</a></li>');

    for(index = curPage - 1; index <= curPage + 1; index++) {
        if(curPage === index) {
            liArr.push('<li class="active"><a href="javascript:;">'+index+'</a></li>');
        } else {
            liArr.push('<li><a href="javascript:;">'+index+'</a></li>');
        }
    }

    liArr.push('<li><a class="dotted" href="javascript:;">...</a></li>');
    liArr.push('<li><a href="javascript:;">'+totalPage+'</a></li>');
    liArr.push('<li class="next"><a href="javascript:;">&raquo;</a></li>');

    return liArr;
}

function handleData(res) {
	totalP = res.pageCount;
	var pageLis = renderPages(curP, totalP);
	$('.pagination').html(pageLis.join(''));
	renderList(res.data);
}

function renderList(data) {
	// for(var index=0;index<data.length;index++){
	// 	console.log(data[index].branchName);
	// 	console.log(data[index].branchAddress);
	// }
	var i = 0;
	var names = [];
	var listType = $('.module-label label').data('list');
	var theads = listThead[listType];
	var theadLis = [];
	var curpage = (curP-1)*15;
	var title = '';
	var filter = $('.filter-wrapper').data('filter');
	if(filter === 'year') {
		title = $('input[name="year"]:checked').val();
		if(title === 'all') {
			title = '总年度';
		}else {
			title += '年';
		}
	}else if(filter === 'time') {
		title = $('.startTime').val() + '年 至 ' + $('.endTime').val() + '年';
	}
	
	//设置标题
	$('.table-title').html(title);
	
	theadLis.push('<th>序号</th>');
	for(i = 0; i < theads.length; i++) {
		theadLis.push('<th>' + theads[i] + '</th>');
	}
	
	// 用于设定奇偶行数据的背景颜色差异
	var bgColor = 'style="background-color:rgba(52, 152, 219, 0.15);"';
	
	var tbodyLis = [];
	if(listType === 'registerHospYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerHospTime') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'registerDepYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'registerDocYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].doctor + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerDocTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + names[2] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	}
	else if(listType === 'externalHospYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'externalHospTime') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'externalDepYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'externalDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'externalDocYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].doctor + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'externalDocTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + names[2] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	}

	else if(listType === 'enterpriseCompanyType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '元</th></tr>');
		}
	}
	else if(listType === 'enterpriseIndustryType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].industry_code + '</th>');
			tbodyLis.push('<th>' + data[i].cardinality + '元</th></tr>');
		}
	}
	else if(listType === 'enterpriseFinancialType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '元</th></tr>');
		}
	}

    else if(listType === 'hos_2HospYear') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].num + '</th></tr>');
        }
    } else if(listType === 'hos_2HospTime') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].num + '% </th></tr>');
        }
    } else if(listType === 'hos_2DepYear') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].department + '</th>');
            tbodyLis.push('<th>' + data[i].num + '</th></tr>');
        }
    } else if(listType === 'hos_2DepTime') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].department + '</th>');
            tbodyLis.push('<th>' + data[i].num + '% </th></tr>');
        }
    } else if(listType === 'hos_2DocYear') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].department + '</th>');
            tbodyLis.push('<th>' + data[i].doctor + '</th>');
            tbodyLis.push('<th>' + data[i].num + '</th></tr>');
        }
    } else if(listType === 'hos_2DocTime') {
        for(i = 0; i < data.length; i++) {
        	if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
            tbodyLis.push('<th>' + data[i].hospital + '</th>');
            tbodyLis.push('<th>' + data[i].department + '</th>');
            tbodyLis.push('<th>' + data[i].doctor + '</th>');
            tbodyLis.push('<th>' + data[i].num + '% </th></tr>');
        }
    }

	if(listType === 'specialHospYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'specialHospTime') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'specialDepYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'specialDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	}

	if(listType === 'expenseHospYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'expenseHospTime') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'expenseDepYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'expenseDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	}

	else if(listType === 'otherHosYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hos_name + '</th>');
			tbodyLis.push('<th>' + data[i].person_num + '</th></tr>');
		}
			
	}else if(listType === 'otherHosTime') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'otherDepYear') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hos_name + '</th>');
			tbodyLis.push('<th>' + data[i].dep_name + '</th>');
			tbodyLis.push('<th>' + data[i].person_num + '</th></tr>');
		}
	} else if(listType === 'otherDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	}else if(listType === 'allData') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].name + '</th>');
			tbodyLis.push('<th>' + data[i].num + '</th>');
			tbodyLis.push('<th>' + data[i].otherNum + '</th>');
			tbodyLis.push('<th>' + (data[i].percent*100).toFixed(2) + '%</th></tr>');
		}
	}
	else if(listType === 'clinicHospYear'){
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	}else if(listType === 'clinicDepYear'){
		for(i = 0;i < data.length; i++){
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	}else if(listType === 'clinicDocYear'){
		for(i = 0;i < data.length; i++){
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].doctor + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	}
	
	if(listType === 'npState'){
		for(i = 0;i < data.length; i++){
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].branchName + '</th>');
			tbodyLis.push('<th>' + data[i].branchAddress + '</th>');
			tbodyLis.push('<th>' + data[i].work + '</th>');
			tbodyLis.push('<th>' + data[i].notWork + '</th></tr>');
		}
	}else if(listType === 'npOperation'){
		for(i = 0;i < data.length; i++){
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].branchName + '</th>');
			tbodyLis.push('<th>' + data[i].branchAddress + '</th>');
			tbodyLis.push('<th>' + data[i].operationAmount + '</th>');			
		}
	}else if(listType == 'npTerminal'){
		for(i = 0;i < data.length; i++){
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].branchName + '</th>');
			tbodyLis.push('<th>' + data[i].branchAddress + '</th>');
			tbodyLis.push('<th>' + data[i].terminalAmount + '</th>');			
		}
	}
	else if(listType === 'terminalType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].category + '</th>');
			tbodyLis.push('<th>' + data[i].value + '</th></tr>');
		}
	}
	else if(listType === 'terminalBusiness') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].category + '</th>');
			tbodyLis.push('<th>' + data[i].device_type + '</th>');
			tbodyLis.push('<th>' + data[i].branch_name + '</th>');
			tbodyLis.push('<th>' + data[i].value + '</th></tr>');
		}
	}
	else if(listType === 'terminalStatus') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].category + '</th>');
			tbodyLis.push('<th>' + data[i].device_type + '</th>');
			tbodyLis.push('<th>' + data[i].branch_name + '</th>');
			tbodyLis.push('<th>' + data[i].value + '</th>');
			tbodyLis.push('<th>' + data[i].errorDays + '</th></tr>');
		}
	}else if(listType === 'cardPrimaryType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].type + '</th>');
			tbodyLis.push('<th>' + data[i].num + '</th></tr>');
		}
	}else if(listType === 'cardDetailType') {
		for(i = 0; i < data.length; i++) {
			if(i % 2 != 0) {
				tbodyLis.push('<tr ' + bgColor + '><th>'+ (curpage+i+1) +'</th>');
			} else {
				tbodyLis.push('<tr><th>'+ (curpage+i+1) +'</th>');
			}
			tbodyLis.push('<th>' + data[i].type + '</th>');
			tbodyLis.push('<th>' + data[i].num + '</th></tr>');
		}
	}
	$('.table thead tr').html(theadLis.join(''));
	$('.table tbody').html(tbodyLis.join(''));
}

/*** loading动画 ***/
//加载loading
function showLoading() {
	$('.spinner').show();
}
//结束loading
function hideLoading() {
	$('.spinner').hide();
}
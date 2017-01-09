var classData = {
		card: [{   
		    	   key: 'register',
		    	   value: '挂号业务'
		       },
		       {   
		    	   key: 'external',
		    	   value: '异地就医业务'
		       },
		       {   
		    	   key: 'special',
		    	   value: '特殊医疗业务'
		}],
		enterprise: [{
			key: 'companyType',
			value: '单位类型参保业务'
		}]
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
		
		companyType: [{
			url: 'charts/company/data',
			key: 'year',
			list: 'enterpriseCompanyType',
			value: '单位类型参保基数分析'
		}]
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
	enterpriseCompanyType: ['单位类型名称', '单位类型参保基数']
};

var curP = 1, totalP = 1;

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
		},
		error: function(err) {
			alert('Error: ' + JSON.stringify(err));
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
	var i = 0;
	var names = [];
	var listType = $('.module-label label').data('list');
	var theads = listThead[listType];
	var theadLis = [];
	
	var title = '';
	var filter = $('.filter-wrapper').data('filter');
	if(filter === 'year') {
		title = $('input[name="year"]:checked').val();
		if(title === 'all') {
			title = '总季度';
		}else {
			title += '年';
		}
	}else if(filter === 'time') {
		title = $('.startTime').val() + '年 至 ' + $('.endTime').val() + '年';
	}
	
	theadLis.push('<th>'+title+'</th>');
	for(i = 0; i < theads.length; i++) {
		theadLis.push('<th>' + theads[i] + '</th>');
	}
	
	var tbodyLis = [];
	if(listType === 'registerHospYear') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerHospTime') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'registerDepYear') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerDepTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'registerDocYear') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].hospital + '</th>');
			tbodyLis.push('<th>' + data[i].department + '</th>');
			tbodyLis.push('<th>' + data[i].doctor + '</th>');
			tbodyLis.push('<th>' + data[i].sum + '</th></tr>');
		}
	} else if(listType === 'registerDocTime') {
		for(i = 0; i < data.length; i++) {
			names = data[i].key.split('-');
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + names[0] + '</th>');
			tbodyLis.push('<th>' + names[1] + '</th>');
			tbodyLis.push('<th>' + names[2] + '</th>');
			tbodyLis.push('<th>' + data[i].value + '% </th></tr>');
		}
	} else if(listType === 'enterpriseCompanyType') {
		for(i = 0; i < data.length; i++) {
			tbodyLis.push('<tr><th>'+ (i+1) +'</th>');
			tbodyLis.push('<th>' + data[i].key + '</th>');
			tbodyLis.push('<th>' + data[i].value + '元</th></tr>');
		}
	}
	
	$('.table thead tr').html(theadLis.join(''));
	$('.table tbody').html(tbodyLis.join(''));
}
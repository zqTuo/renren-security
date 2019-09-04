$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/code/list',
        datatype: "json",
        colModel: [			
			{ label: 'codeId', name: 'codeId', index: 'code_id', width: 50, key: true },
			{ label: '广告主id', name: 'advertisersId', index: 'advertisers_id', width: 80 }, 			
			{ label: '商家id', name: 'sellerId', index: 'seller_id', width: 80 }, 			
			{ label: '活动id', name: 'activityId', index: 'activity_id', width: 80 }, 			
			{ label: '参与类型', name: 'activityType', index: 'activity_type', width: 80 }, 			
			{ label: '是否关注', name: 'isFocus', index: 'is_focus', width: 80 }, 			
			{ label: '是否扫码', name: 'isQr', index: 'is_qr', width: 80 }, 			
			{ label: '扫码用户id', name: 'codeUser', index: 'code_user', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		code: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.code = {};
		},
		update: function (event) {
			var codeId = getSelectedRow();
			if(codeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(codeId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.code.codeId == null ? "sys/code/save" : "sys/code/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: vm.code,
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var codeIds = getSelectedRows();
			if(codeIds == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/code/delete",
                        contentType: "application/json",
                        data: codeIds,
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(codeId){
			$.get(baseURL + "sys/code/info/"+codeId, function(r){
                vm.code = r.code;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
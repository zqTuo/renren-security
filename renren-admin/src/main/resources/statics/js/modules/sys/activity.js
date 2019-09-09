$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/activity/list',
        datatype: "json",
        colModel: [			
			{ label: '活动编号', name: 'activityId', index: 'activity_id', width: 50, key: true },
			{ label: '活动名称', name: 'activityName', index: 'activity_name', width: 80 },
			{ label: '活动链接', name: 'activityAddress', index: 'seller_address', width: 80 },
			{ label: '是否关注', name: 'isFocus', index: 'is_focus', width: 80 , formatter:function (cellValue) {
                    if(cellValue === 1){
                        return "<span class='label label-success radius'>是</span>";
                    }else{
                        return "<span class='label label-danger radius'>否</span>";
                    }
                } },
			{ label: '是否扫码', name: 'isQr', index: 'is_qr', width: 80 , formatter:function (cellValue) {
                    if(cellValue === 1){
                        return "<span class='label label-success radius'>是</span>";
                    }else{
                        return "<span class='label label-danger radius'>否</span>";
                    }
                } },

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

        gridComplete:function() {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }

    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		activity: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.activity = {};
		},
		update: function (event) {
			var activityId = getSelectedRow();
			if(activityId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(activityId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.activity.activityId == null ? "sys/activity/save" : "sys/activity/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.activity),
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
			var activityIds = getSelectedRows();
			if(activityIds == null){
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
                        url: baseURL + "sys/activity/delete",
                        contentType: "application/json",
                        data: JSON.stringify(activityIds),
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
		getInfo: function(activityId){
			$.get(baseURL + "sys/activity/info/"+activityId, function(r){
                vm.activity = r.activity;
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
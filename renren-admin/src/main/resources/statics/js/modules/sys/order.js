$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/order/list',
        datatype: "json",
        colModel: [			
			{ label: '订单编号', name: 'orderId', index: 'order_id', width: 50, key: true },
			{ label: '订单创建时间', name: 'createTime', index: 'create_time', width: 80 },
			{ label: '广告主名称', name: 'advertisersId', index: 'advertisers_id', width: 80 },
			{ label: '商家名称', name: 'sellerId', index: 'seller_id', width: 80 }
           /* {
                label:'查询',  name: 'orderId', index: 'order_id', width: 80, fixed: true, sortable: false, resize: false,

                formatter: function (value, grid, rows, state) { return "<a href=\"#\" style=\"color:dodgerblue\" @click=\"update\">订单详情</a>" }

            },*/


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
            var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
        },
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		showList01: false,
		showList02: true,
		title: null,
		order: {},
        bonus:{},
        detailList:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
		},
		update: function (event) {
			var orderId = getSelectedRow();
			if(orderId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "查看";
            
            vm.getInfo(orderId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.order.orderId == null ? "sys/order/save" : "sys/order/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.order),
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
			var orderIds = getSelectedRows();
			if(orderIds == null){
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
                        url: baseURL + "sys/order/delete",
                        contentType: "application/json",
                        data: JSON.stringify(orderIds),
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
		getInfo: function(orderId){
			$.get(baseURL + "sys/order/info/"+orderId, function(r){
                vm.order = r.order;
                vm.detailList = r.detailList;
            });
		},
        findBonusById: function(orderId){
            $.get(baseURL + "sys/bonus/findBonusById/"+orderId, function(r){
                vm.bonus = r.bonus;

            });
        },
        addBonus:function(){

            vm.showList02 = false;
            vm.showList01= true,
                vm.title = "新增";
            vm.order = {};
        },
        updateBonus:function(event){
            var orderId = getSelectedRow();
            if(orderId == null){
                return ;
            }
            vm.showList01= true,
            vm.showList02 = false;
            vm.title = "查看";

            vm.findBonusById(orderId)
        },

		reload: function (event) {
			vm.showList01 = false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
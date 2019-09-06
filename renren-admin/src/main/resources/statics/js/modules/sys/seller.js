$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/seller/list',
        datatype: "json",
        colModel: [
			{ label: '店铺名称', name: 'nickName', index: 'nick_name', width: 80 }, 			
			{ label: '密码', name: 'password', index: 'password', width: 80 }, 			
			{ label: 'EMAIL', name: 'email', index: 'email', width: 80 }, 			
			{ label: '公司手机', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '公司电话', name: 'telephone', index: 'telephone', width: 80 },
			{ label: '详细地址', name: 'addressDetail', index: 'address_detail', width: 80 }, 			
			{ label: '联系人姓名', name: 'linkmanName', index: 'linkman_name', width: 80 },
			{ label: '职位', name: 'linkmanJod', index: 'linkman_jod', width: 80 },
			{ label: '营业执照号', name: 'licenseNumber', index: 'license_number', width: 80 }, 			
			{ label: '税务登记证号', name: 'taxNumber', index: 'tax_number', width: 80 }, 			
			{ label: '组织机构代码', name: 'orgNumber', index: 'org_number', width: 80 }, 			
			{ label: '公司地址', name: 'address', index: 'address', width: 80 },
			{ label: '简介', name: 'brief', index: 'brief', width: 80 },
			{ label: '法定代表人', name: 'legalPerson', index: 'legal_person', width: 80 }

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
		seller: {}
	},
	methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.seller = {};
        },
        update: function (event) {
            var sellerId = getSelectedRow();
            if (sellerId == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(sellerId)
        },
        saveOrUpdate: function (event) {
            $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function () {
                var url = vm.seller.sellerId == null ? "sys/seller/save" : "sys/seller/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.seller),
                    success: function (r) {
                        if (r.code === 0) {
                            layer.msg("操作成功", {icon: 1});
                            vm.reload();
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        } else {
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
            });
        },
        del: function (event) {
            var sellerIds = getSelectedRows();
            if (sellerIds == null) {
                return;
            }
            var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                if (!lock) {
                    lock = true;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/seller/delete",
                        contentType: "application/json",
                        data: sellerIds,
                        success: function (r) {
                            if (r.code == 0) {
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            }, function () {
            });
        },
        getInfo: function (sellerId) {
            $.get(baseURL + "sys/seller/info/" + sellerId, function (r) {
                vm.seller = r.seller;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        },
        exportExcel() {
            window.location.href = '/renren-admin/admin/upload/exportExcel';
        }
    }

});
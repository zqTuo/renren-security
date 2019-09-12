$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/orderdesc/list',
        datatype: "json",
        colModel: [
			{ label: '订单详情编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '商家名字', name: 'sellerName', index: 'seller_name', width: 80 },
			{ label: '二维码数量', name: 'num', index: 'num', width: 80 },
			{ label: '订单编号', name: 'orderId', index: 'order_id', width: 80 },
			{ label: '商家编号', name: 'sellerId', index: 'seller_id', width: 80 }
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
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        orderDesc: {},
        orderDesclist:[]
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.orderDesc = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function () {
                var url = vm.orderDesc.id == null ? "sys/orderdesc/save" : "sys/orderdesc/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.orderDesc),
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
            var ids = getSelectedRows();
            if (ids == null) {
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
                        url: baseURL + "sys/orderdesc/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
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
        getInfo: function (id) {
            $.get(baseURL + "sys/orderdesc/info/" + id, function (r) {
                vm.orderDesc = r.orderDesc;
            });
        },
        findAllByOrderId: function (OrderId) {
            $.get(baseURL + "sys/orderdesc/findAllByOrderId/" + OrderId, function (r) {
                vm.orderDesclist = r.OrderDescList;

            });
           this.reload(OrderId)
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData:{'name': event},
                page: page
            }).trigger("reloadGrid");
        }
    },
 /*   created: function () {
        var urlParam = this.getUrlParam("id");

        var id = urlParam.id
        console.log(id)
        if (id != null || id != undefined) {
            this.findAllByOrderId(id)
        } else {

            $("#jqGrid").jqGrid({
                url: baseURL + 'sys/orderdesc/list',
                datatype: "json",
                colModel: [
                    {label: '订单详情编号', name: 'id', index: 'id', width: 200, key: true},
                    {label: '商家名字', name: 'sellerName', index: 'seller_name', width: 230},
                    {label: '二维码数量', name: 'num', index: 'num', width: 230},
                    {label: '订单编号', name: 'orderId', index: 'order_id', width: 230},
                    {label: '商家编号', name: 'sellerId', index: 'seller_id', width: 230}
                ],
                viewrecords: true,
                height: 385,
                rowNum: 10,
                rowList: [10, 30, 50],
                rownumbers: true,
                rownumWidth: 25,
                autowidth: true,
                multiselect: true,
                pager: "#jqGridPager",
                jsonReader: {
                    root: "page.list",
                    page: "page.currPage",
                    total: "page.totalPage",
                    records: "page.totalCount"
                },
                prmNames: {
                    page: "page",
                    rows: "limit",
                    order: "order"
                },
                gridComplete: function () {
                    //隐藏grid底部滚动条
                    $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
                }
            });
        }
    }*/
});
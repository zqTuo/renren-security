$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/advertisers/list',
        datatype: "json",
        colModel: [			
			{ label: 'advertisersId', name: 'advertisersId', index: 'advertisers_id', width: 50, key: true },
            /*
			{ label: '公司名', name: 'name', index: 'name', width: 80 },
			{ label: 'EMAIL', name: 'email', index: 'email', width: 80 }, 			
			{ label: '公司手机', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '公司电话', name: 'telephone', index: 'telephone', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 },
			{ label: '详细地址', name: 'addressDetail', index: 'address_detail', width: 80 }, 			
			{ label: '联系人姓名', name: 'linkmanName', index: 'linkman_name', width: 80 }, 			
			{ label: '联系人QQ', name: 'linkmanQq', index: 'linkman_qq', width: 80 }, 			
			{ label: '联系人电话', name: 'linkmanMobile', index: 'linkman_mobile', width: 80 }, 			
			{ label: '联系人EMAIL', name: 'linkmanEmail', index: 'linkman_email', width: 80 }, 			
			{ label: '营业执照号', name: 'licenseNumber', index: 'license_number', width: 80 }, 			
			{ label: '税务登记证号', name: 'taxNumber', index: 'tax_number', width: 80 }, 			
			{ label: '组织机构代码', name: 'orgNumber', index: 'org_number', width: 80 }, 			
			{ label: '公司地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '公司LOGO图', name: 'logoPic', index: 'logo_pic', width: 80 },
			{ label: '简介', name: 'brief', index: 'brief', width: 80 }, 			
			{ label: '创建日期', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '法定代表人', name: 'legalPerson', index: 'legal_person', width: 80 }, 			
			{ label: '法定代表人身份证', name: 'legalPersonCardId', index: 'legal_person_card_id', width: 80 }, 			
			{ label: '开户行账号名称', name: 'bankUser', index: 'bank_user', width: 80 }, 			
			{ label: '是否渠道客户', name: 'customers', index: 'customers', width: 80 }, 			
			{ label: '充值金额', name: 'money', index: 'money', width: 80 }, 			
			{ label: '订单列表', name: 'orderlist', index: 'orderList', width: 80 }, 			
			{ label: '职位', name: 'jod', index: 'jod', width: 80 }, 			
			{ label: '类型', name: 'type', index: 'type', width: 80 }*/
            { label: '公司名', name: 'name', index: 'name', width: 80 },
            { label: 'EMAIL', name: 'email', index: 'email', width: 80 },
            { label: '公司手机', name: 'mobile', index: 'mobile', width: 80 },
            { label: '公司电话', name: 'telephone', index: 'telephone', width: 80 },
            { label: '详细地址', name: 'addressDetail', index: 'address_detail', width: 80 },
            { label: '联系人姓名', name: 'linkmanName', index: 'linkman_name', width: 80 },
            { label: '联系人电话', name: 'linkmanMobile', index: 'linkman_mobile', width: 80 },
            { label: '营业执照号', name: 'licenseNumber', index: 'license_number', width: 80 },
            { label: '公司地址', name: 'address', index: 'address', width: 80 },
            { label: '简介', name: 'brief', index: 'brief', width: 80 },
            { label: '创建日期', name: 'createTime', index: 'create_time', width: 80 },
            { label: '法定代表人', name: 'legalPerson', index: 'legal_person', width: 80 },
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
        showList02: true,
        showList03: true,
		title: null,
		advertisers: {},
        sellerList:{},
        activityList:{},
        order:{orderEntity:{},orderDescEntity:[]},
        entity:{},

	},
	methods: {
        addOrderDesc_Entity:function () {
            //向数组中添加一个对象
            this.order.orderDescEntity.push(this.entity);
        },

        removeOrderDesc_Entity:function (index) {
            //向数组中添加一个对象
            this.order.orderDescEntity.splice(index, 1);
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.showList03 = false;

			vm.title = "新增";
			vm.advertisers = {};
		},
		update: function (event) {
			var advertisersId = getSelectedRow();
			if(advertisersId == null){
				return ;
			}
			vm.showList = false;
			vm.showList03 = false;

            vm.title = "修改";
            
            vm.getInfo(advertisersId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.advertisers.advertisersId == null ? "sys/advertisers/save" : "sys/advertisers/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.advertisers),
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
			var advertisersIds = getSelectedRows();
			if(advertisersIds == null){
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
                        url: baseURL + "sys/advertisers/delete",
                        contentType: "application/json",
                        data: JSON.stringify(advertisersIds),
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
		getInfo: function(advertisersId){
			$.get(baseURL + "sys/advertisers/info/"+advertisersId, function(r){
                vm.advertisers = r.advertisers;
            });
		},
		reload: function (event) {
			vm.showList03 = true;
			vm.showList=true
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        QrCode:function () {
            vm.showList02 = false;
            vm.showList03 = false;
            vm.title = "生成二维码";
            this.findAllSeller();
            this.findAllActivity();
        },
        addQrCode:function () {
			console.log(this.order.orderDescEntity)
            axios.post('/icode-admin/sys/advertisers/QrCode',this.order).then(function (r) {
                if(r.code == 0){
                    layer.msg("操作成功", {icon: 1});
                    $("#jqGrid").trigger("reloadGrid");
                }else{
                    layer.alert(r.msg);
                }
            })
        },
        findAllSeller:function () {
            axios.get('/icode-admin/sys/seller/list').then(function (response) {

               var page = response.data.page;
                vm.sellerList=page.list


            }).catch(function (error) {
                console.log("1231312131321");
            });
        },
        findAllActivity:function () {
            axios.get('/icode-admin/sys/activity/list').then(function (response) {

                var page = response.data.page;
                vm.activityList=page.list
            }).catch(function (error) {
                console.log("1231312131321");
            });
        },

    },

});
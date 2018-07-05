<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<script type="text/javascript">
		$(function(){
			$("#dg").datagrid({
			    url:"${pageContext.request.contextPath}/picture/queryPictureByPage",
			    columns:[[    
			        {field:"pictureId",title:"图片编号",width:100},
			        {field:"pictureName",title:"文件名",width:100},
                    {field:"pictureMessage",title:"描述信息",width:100},
			        {field:"pictureStatus",title:"轮播图状态",width:100},
                    {field:"pictureDate",title:"轮播图创建时间",width:100},
			    ]],
				striped:true,
				pagination:true,
				pageList:[5,10,15,20],
				pageSize : 5,
				toolbar : "#tb",
				fitColumns: true,
				singleSelect:true,
                remoteSort:false,
                nowrap:false,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="images/' + rowData.itemid + '.png" style="height:50px;"></td>' +
                        '</tr></table>';
                }

            });
			
			$("#modify").linkbutton({
				onClick:function(){
					var rowData = $("#dg").datagrid("getSelected");
					console.log(rowData);
					$("#dd").dialog({
                        title: '修改员工信息',
						width:300,
						height:251,
                        modal: true,
						href:"${pageContext.request.contextPath}/modifyform.jsp", //包含子页面
						onLoad:function(){
							$("#mf").form("load",rowData); //在加载表单时将行数据加载到表单元素中
						}
						
						
					});
					
				},
				
			});
			
			
			$("#register").linkbutton({
				onClick:function(){
					var rowData = $("#dg").datagrid("getSelected");
					console.log(rowData);
					$("#dd").dialog({
                        title: '添加新员工信息',
						width:300,
						height:251,
                        modal: true,
						href:"${pageContext.request.contextPath}/registerform.jsp", //包含子页面
					});
				},
			});
			

			/*删除员工*/
			$("#cancel").linkbutton({
				onClick:function(){
					var rowData = $("#dg").datagrid("getSelected");
					console.log(rowData);

                    $('#confirm').dialog({
                        title: '是否删除？',
                        width: 400,
                        height: 200,
                        closed: false,
                        cache: false,
                        // href: 'get_content.php',
                        modal: true,
                        toolbar:[{

                        }],
                        buttons:[{
                            text:'确认',
                            iconCls:'icon-ok',
                            handler:function(){
                                $.ajax({
                                    type:"POST",
                                    url:"${pageContext.request.contextPath}/employee/cancelEmp",
                                    data:"id="+rowData.id,
                                    success: function(){
                                        $("#dg").datagrid('load',{

                                        });
                                        $("#confirm").window("close");
                                    }
                                });
                            }
                        },{
                            text:'取消',
                            iconCls:'icon-cancel',
                            handler:function(){
                                $("#confirm").window("close");

							}
                        }],
                    });
					
				},
				
			});
			
			
		});
		
		function qq(value, name) {
            $("#dg").datagrid('load',{
                value:value,
                name:name
            });
		}
		
	</script>
	

	<table id="dg"></table>  
	
	<div id="tb" style="display: none">
		<a id="modify" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
		<a id="register" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
		<a id="cancel" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>
		<input id="ss" class="easyui-searchbox" style="width:300px"
			data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mm'"></input>
		<div id="mm" style="width:120px">
			<div data-options="name:'name',iconCls:'icon-ok'">姓名</div>
			<div data-options="name:'department',iconCls:'icon-ok'">部门</div>
			<div data-options="name:'address',iconCls:'icon-ok'">地址</div>
		</div>
		
		<div id="dd"></div>
		<div id="confirm"></div>
	</div>



	


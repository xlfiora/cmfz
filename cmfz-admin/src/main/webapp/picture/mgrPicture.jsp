<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<script type="text/javascript">
		$(function(){
			$("#picture_dg").datagrid({
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
				toolbar : "#picture_tb",
				fitColumns: true,
				singleSelect:true,
                remoteSort:false,
                nowrap:false,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td style="border:0"><img src="upload/picture/' + rowData.pictureName + '" style="height:150px;"></td>' +
                        '</tr></table>';
                }

            });
			
			$("#picture_modify").linkbutton({
				onClick:function(){
					var rowData = $("#picture_dg").datagrid("getSelected");
					console.log(rowData);
					$("#picture_dd").dialog({
                        title: '修改图片信息',
						width:300,
						height:200,
                        modal: true,
						href:"${pageContext.request.contextPath}/picture/modifyPictureform.jsp", //包含子页面
						onLoad:function(){
							$("#picture_mf").form("load",rowData); //在加载表单时将行数据加载到表单元素中
						}
						
						
					});
					
				},
				
			});
			
			
			$("#picture_add").linkbutton({
				onClick:function(){
					var rowData = $("#picture_dg").datagrid("getSelected");
					console.log(rowData);
					$("#picture_dd").dialog({
                        title: '新增轮播图',
						width:360,
						height:200,
                        modal: true,
						href:"${pageContext.request.contextPath}/picture/addPictureform.jsp", //包含子页面
					});
				},
			});
			

			/*删除图片*/
			$("#picture_remove").linkbutton({
				onClick:function(){
					var rowData = $("#picture_dg").datagrid("getSelected");
					console.log(rowData);

                    $('#picture_confirm').dialog({
                        title: '是否删除？',
                        width: 400,
                        height: 200,
                        closed: false,
                        cache: false,
                        // href: 'get_content.php',
						content:"你确定要删除吗？",
                        modal: true,
                        toolbar:[{

                        }],
                        buttons:[{
                            text:'确认',
                            iconCls:'icon-accept',
                            handler:function(){
                                $.ajax({
                                    type:"POST",
                                    url:"${pageContext.request.contextPath}/picture/removePicture",
                                    data:"pictureId="+rowData.pictureId,
                                    success: function(){
                                        $("#picture_dg").datagrid('load',{

                                        });
                                        $("#picture_confirm").window("close");
                                    }
                                });
                            }
                        },{
                            text:'取消',
                            iconCls:'icon-cancel',
                            handler:function(){
                                $("#picture_confirm").window("close");

							}
                        }],
                    });
					
				},
				
			});
			
			
		});
		
		function picture_qq(value, name) {
            $("#picture_dg").datagrid('load',{
                value:value,
                name:name
            });
		}
		
	</script>
	

	<table id="picture_dg"></table>
	
	<div id="picture_tb" style="display: none">
		<a id="picture_modify" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
		<a id="picture_add" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
		<a id="picture_remove" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>
		<%--<input id="picture_ss" class="easyui-searchbox" style="width:300px"
			data-options="searcher:picture_qq,prompt:'请您输入需要模糊查询的内容',menu:'#picture_mm'"></input>
		<div id="picture_mm" style="width:120px">
			<div data-options="name:'name',iconCls:'icon-ok'">姓名</div>
			<div data-options="name:'department',iconCls:'icon-ok'">部门</div>
			<div data-options="name:'address',iconCls:'icon-ok'">地址</div>
		</div>--%>
		
		<div id="picture_dd"></div>
		<div id="picture_confirm"></div>
	</div>



	


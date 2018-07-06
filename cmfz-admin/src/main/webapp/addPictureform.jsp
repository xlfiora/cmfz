<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
 		$("#picture_af_submit").linkbutton({
 			onClick:function(){
 				$("#picture_af").form("submit", {
 				    url:"${pageContext.request.contextPath}/picture/addPicture",
 				    onSubmit: function(){    
 				        // do some check    
 				        // return false to prevent submit;    
 				    },    
 				    success:function(){
                        $("#picture_dg").datagrid('load',{

                        });
 				    	$("#picture_dd").dialog("close");
 				    }    
 				});
 				
 			},
 			
 		});

        $("#picture_mf_cancel").linkbutton({
            onClick:function () {
                $("#picture_dd").dialog("close");
            },
        });

	});


</script>
<form id="picture_af" method="post" enctype="multipart/form-data">
	<div style="margin-left: 20px;margin-top: 20px">
		<table>
			<tr>
				<td>轮播图描述:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="pictureMessage"/></td>
			</tr>
			<tr>
				<td>轮播图状态:</td>
				<td>
					<select class="easyui-combobox" data-options="required:true," name="pictureStatus">
						<option value="展示">展示</option>
						<option value="不展示">不展示</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>上传轮播图:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="newPicture" type="file"/></td>
			</tr>
			<tr>
				<td><a id="picture_af_submit" class="easyui-linkbutton" data-options="iconCls:'icon-picture_save'">保存</a></td>
				<td><a id="picture_af_cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>
		</table>



	</div>

</form>
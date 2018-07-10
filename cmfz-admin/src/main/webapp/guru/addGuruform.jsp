<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
 		$("#guru_af_submit").linkbutton({
 			onClick:function(){
 				$("#guru_af").form("submit", {
 				    url:"${pageContext.request.contextPath}/guru/addGuru",
 				    onSubmit: function(){    
 				        // do some check    
 				        // return false to prevent submit;    
 				    },    
 				    success:function(){
                        $("#guru_dg").datagrid('load',{

                        });
 				    	$("#guru_dd").dialog("close");
 				    }    
 				});
 				
 			},
 			
 		});

        $("#guru_af_cancel").linkbutton({
            onClick:function () {
                $("#guru_dd").dialog("close");
            },
        });

	});


</script>
<form id="guru_af" method="post" enctype="multipart/form-data">
	<div style="margin-left: 20px;margin-top: 20px">
		<table>
			<tr>
				<td>上师名:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="guruName"/></td>
			</tr>
			<tr>
				<td>上师简介:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="guruIntroduction"/></td>
			</tr>
			<tr>
				<td>上师照片:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="guruPhoto" type="file"/></td>
			</tr>
			<tr>
				<td><a id="guru_af_submit" class="easyui-linkbutton" data-options="iconCls:'icon-picture_save'">保存</a></td>
				<td><a id="guru_af_cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>
		</table>



	</div>

</form>
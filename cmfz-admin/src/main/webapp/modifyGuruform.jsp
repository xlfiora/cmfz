<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
 		$("#guru_mf_submit").linkbutton({
 			onClick:function(){
 				$("#guru_mf").form("submit", {
 				    url:"${pageContext.request.contextPath}/guru/modifyGuru",
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


 		$("#guru_mf_cancel").linkbutton({
			onClick:function () {
                $("#guru_dd").dialog("close");
            },
		});
	});


</script>
<form id="guru_mf" method="post">
	<div style="margin-left: 20px;margin-top: 20px">
		<table>
			<input type="text" name="guruId" style="display: none"/>
			<tr>
				<td>上师名:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="guruName"/></td>
			</tr>
			<tr>
				<td>上师简介:</td>
				<td><input class="easyui-validatebox" data-options="required:true," name="guruIntroduction"/></td>
			</tr>
			<tr>
				<td><a id="guru_mf_submit" class="easyui-linkbutton" data-options="iconCls:'icon-picture_save'">保存</a></td>
				<td><a id="guru_mf_cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>
		</table>
	</div>

</form>
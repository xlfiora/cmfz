<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
 		$("#guru_asf_submit").linkbutton({
 			onClick:function(){
 				$("#guru_asf").form("submit", {
 				    url:"${pageContext.request.contextPath}/guru/addGuruByExcel",
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

        $("#guru_asf_cancel").linkbutton({
            onClick:function () {
                $("#guru_dd").dialog("close");
            },
        });

	});


</script>
<form id="guru_asf" method="post" enctype="multipart/form-data">
	<div style="margin-left: 20px;margin-top: 20px">
		<table>
			<tr>
				<td>上师信息表:</td>
				<td><input class="easyui-filebox" data-options="required:true," name="guruExcel"/></td>
			</tr>
			<tr>
				<td><a id="guru_asf_submit" class="easyui-linkbutton" data-options="iconCls:'icon-picture_save'">保存</a></td>
				<td><a id="guru_asf_cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>
		</table>



	</div>

</form>
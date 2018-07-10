<%--
  Created by IntelliJ IDEA.
  User: xl
  Date: 2018/7/9 0009
  Time: 下午 22:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#log_dg").datagrid({
            url:"${pageContext.request.contextPath}/log/queryLogByPage",
            columns:[[
                {field:"logId",title:"日志编号",width:100},
                {field:"userName",title:"管理员名",width:100},
                {field:"logDate",title:"日志时间",width:100},
                {field:"logResource",title:"事物源",width:100},
                {field:"logAction",title:"事物名",width:100},
                {field:"logMessage",title:"事物详细信息",width:100},
                {field:"logResult",title:"事物结果",width:100},
            ]],
            striped:true,
            pagination:true,
            pageList:[5,10,15,20],
            pageSize : 5,
            //toolbar : "#guru_tb",
            fitColumns: true,
            singleSelect:true,
            remoteSort:false,
            nowrap:false,
//            view: detailview,
//            detailFormatter: function(rowIndex, rowData){
//                return '<table><tr>' +
//                    '<td style="border:0"><img src="upload/guru/' + rowData.guruPhoto + '" style="height:150px;"></td>' +
//                    '</tr></table>';
//            }

        });

        <%--$("#guru_modify").linkbutton({--%>
            <%--onClick:function(){--%>
                <%--var rowData = $("#guru_dg").datagrid("getSelected");--%>
                <%--console.log(rowData);--%>
                <%--$("#guru_dd").dialog({--%>
                    <%--title: '修改上师信息',--%>
                    <%--width:300,--%>
                    <%--height:200,--%>
                    <%--modal: true,--%>
                    <%--href:"${pageContext.request.contextPath}/guru/modifyGuruform.jsp", //包含子页面--%>
                    <%--onLoad:function(){--%>
                        <%--$("#guru_mf").form("load",rowData); //在加载表单时将行数据加载到表单元素中--%>
                    <%--}--%>


                <%--});--%>

            <%--},--%>

        <%--});--%>


        <%--$("#guru_add").linkbutton({--%>
            <%--onClick:function(){--%>
                <%--$("#guru_dd").dialog({--%>
                    <%--title: '新增上师信息',--%>
                    <%--width:360,--%>
                    <%--height:200,--%>
                    <%--modal: true,--%>
                    <%--href:"${pageContext.request.contextPath}/guru/addGuruform.jsp", //包含子页面--%>
                <%--});--%>
            <%--},--%>
        <%--});--%>

        <%--$("#guru_adds").linkbutton({--%>
            <%--onClick:function(){--%>
                <%--$("#guru_dd").dialog({--%>
                    <%--title: '批量插入上师信息',--%>
                    <%--width:360,--%>
                    <%--height:200,--%>
                    <%--modal: true,--%>
                    <%--href:"${pageContext.request.contextPath}/guru/addGurusform.jsp", //包含子页面--%>
                <%--});--%>
            <%--},--%>
        <%--});--%>

        <%--$("#guru_export").linkbutton({--%>
            <%--onClick:function(){--%>
                <%--window.location.href="${pageContext.request.contextPath}/guru/exportGuruExcel";--%>
            <%--},--%>
        <%--});--%>


        <%--/*删除图片*/--%>
        <%--$("#guru_remove").linkbutton({--%>
            <%--onClick:function(){--%>
                <%--var rowData = $("#guru_dg").datagrid("getSelected");--%>
                <%--console.log(rowData);--%>

                <%--$('#guru_confirm').dialog({--%>
                    <%--title: '是否删除？',--%>
                    <%--width: 400,--%>
                    <%--height: 200,--%>
                    <%--closed: false,--%>
                    <%--cache: false,--%>
                    <%--// href: 'get_content.php',--%>
                    <%--content:"你确定要删除吗？",--%>
                    <%--modal: true,--%>
                    <%--toolbar:[{--%>

                    <%--}],--%>
                    <%--buttons:[{--%>
                        <%--text:'确认',--%>
                        <%--iconCls:'icon-accept',--%>
                        <%--handler:function(){--%>
                            <%--$.ajax({--%>
                                <%--type:"POST",--%>
                                <%--url:"${pageContext.request.contextPath}/guru/removeGuru",--%>
                                <%--data:"guruId="+rowData.guruId,--%>
                                <%--success: function(){--%>
                                    <%--$("#guru_dg").datagrid('load',{--%>

                                    <%--});--%>
                                    <%--$("#guru_confirm").window("close");--%>
                                <%--}--%>
                            <%--});--%>
                        <%--}--%>
                    <%--},{--%>
                        <%--text:'取消',--%>
                        <%--iconCls:'icon-cancel',--%>
                        <%--handler:function(){--%>
                            <%--$("#guru_confirm").window("close");--%>

                        <%--}--%>
                    <%--}],--%>
                <%--});--%>

            <%--},--%>

        <%--});--%>


    });

//    function guru_qq(value, name) {
//        $("#guru_dg").datagrid('load',{
//            value:value,
//            name:name
//        });
//    }

</script>


<table id="log_dg"></table>

<%--<div id="guru_tb" style="display: none">--%>
    <%--<a id="guru_modify" class="easyui-linkbutton"--%>
       <%--data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>--%>
    <%--<a id="guru_add" class="easyui-linkbutton"--%>
       <%--data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>--%>
    <%--<a id="guru_remove" class="easyui-linkbutton"--%>
       <%--data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>--%>
    <%--<a id="guru_adds" class="easyui-linkbutton"--%>
       <%--data-options="iconCls:'icon-disk_upload',plain:true,text:'批量插入'"></a>--%>
    <%--<a id="guru_export" class="easyui-linkbutton"--%>
       <%--data-options="iconCls:'icon-disk_download',plain:true,text:'导出Excel'"></a>--%>
    <%--<input id="guru_ss" class="easyui-searchbox" style="width:300px"--%>
           <%--data-options="searcher:guru_qq,prompt:'请您输入需要模糊查询的内容',menu:'#guru_mm'"></input>--%>
    <%--<div id="guru_mm" style="width:120px">--%>
        <%--<div data-options="name:'name',iconCls:'icon-ok'">上师名</div>--%>
        <%--&lt;%&ndash;<div data-options="name:'department',iconCls:'icon-ok'">部门</div>--%>
        <%--<div data-options="name:'address',iconCls:'icon-ok'">地址</div>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--<div id="guru_dd"></div>--%>
    <%--<div id="guru_confirm"></div>--%>
<%--</div>--%>










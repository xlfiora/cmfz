<%--
  Created by IntelliJ IDEA.
  User: xl
  Date: 2018/7/8 0008
  Time: 下午 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>



</head>
<body>
    <form id="article_af" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td width="100px">文章标题</td>
                <td><input id="article_title" name="articleTitle"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td> <input class="easyui-switchbutton" name="articleStatus" data-options="onText:'上架',offText:'未上架'"></td>
            </tr>
            <tr>
                <td width="100px">文章作者</td>
                <td><input id="cc" class="easyui-combobox" name="articleAuthor"
                           data-options="valueField:'guruId',textField:'guruName',url:'${pageContext.request.contextPath}/guru/queryGuru'"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="article_editor">
                        <p>请输入文章内容...</p>
                    </div>

                </td>
            </tr>
            <tr>
                <td> <a id="article_submit" href="#"></a></td>
                <td><a id="article_reset" href="#"></a></td>
            </tr>
        </table>
    </form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#article_editor');
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/uploadFiles';//图片上传到服务器
        editor.customConfig.uploadFileName = 'files';//上传图片名称
        editor.create();

        $(function () {
            $("#article_title").textbox({
                required: true,
                validateOnCreate: false,
                validateOnBlur: true,
                prompt: "请您输入文章的标题",
            });

            $('#article_submit').linkbutton({
                text: '创建文章',
                onClick: function () {

                    $('#article_af').form('submit', {

                        url:"${pageContext.request.contextPath}/article/addArticle",
                        onSubmit: function(param){
                            param.articleContent = (editor).txt.html();
                        },
                        success:function () {
                            $.messager.show({
                                title:'提交成功',
                                msg:'文章创建成功！',
                                timeout:5000,
                                showType:'slide'
                            });

                            $('#article_af').form('reset');
                            //括号内有东西是赋值没有事获取
                            (editor).txt.html("");
                        }
                    });

                },
            });
            $('#article_reset').linkbutton({
                text: '重置内容',
                onClick: function () {
                    $('#article_af').form('reset');
                    //括号内有东西是赋值没有事获取
                    (editor).txt.html("");
                },
            });
        });
    </script>
    </body>
</html>
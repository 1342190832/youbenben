<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>


<!DOCTYPE html>
<!-- saved from url=(0043)http://getbootstrap.com/examples/dashboard/ -->
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${baseURL}/" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  Spring Bean Manage Console</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
   
   

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- bootstrap 4.x is supported. You can also use the bootstrap css 3.3.x versions -->
<!--
link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous"
-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<!-- if using RTL (Right-To-Left) orientation, load the RTL CSS file after fileinput.css by uncommenting below -->
<!-- link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/css/fileinput-rtl.min.css" media="all" rel="stylesheet" type="text/css" /-->
<!-- the font awesome icon library if using with `fas` theme (or Bootstrap 4.x). Note that default icons used in the plugin are glyphicons that are bundled only with Bootstrap 3.x. -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
<!-- piexif.min.js is needed for auto orienting image files OR when restoring exif data in resized images and when you
    wish to resize images before upload. This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/js/plugins/piexif.min.js" type="text/javascript"></script>
<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview. 
    This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/js/plugins/sortable.min.js" type="text/javascript"></script>
<!-- purify.min.js is only needed if you wish to purify HTML content in your preview for 
    HTML files. This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/js/plugins/purify.min.js" type="text/javascript"></script>
<!-- popper.min.js below is needed if you use bootstrap 4.x (for popover and tooltips). You can also use the bootstrap js 
   3.3.x versions without popper.min.js. -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- bootstrap.min.js below is needed if you wish to zoom and preview file content in a detail modal
    dialog. bootstrap 4.x is supported. You can also use the bootstrap js 3.3.x versions. -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<!-- the main fileinput plugin file -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/js/fileinput.min.js"></script>
<!-- following theme script is needed to use the Font Awesome 5.x theme (`fas`) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/themes/fas/theme.min.js"></script>
<!-- optionally if you need translation for your language then include the locale file as mentioned below (replace LANG.js with your language locale) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/js/locales/LANG.js"></script>

 <style type="text/css">
* {
	margin: 0;
	padding: 0;
}
.card {
	border: 1px solid #a4a4a4;
	border-radius: 12px;
	margin: 15px;
	box-sizing: border-box;
}
.card .card-title {
	font-size: 120%;
	background-color: #e5e5e5;
	border-bottom: 1px solid #a4a4a4;
	padding: 10px 10px 0px 10px;
	border-radius: 11px 11px 0px 0px;
}
.card .card-body {
	padding: 3px 10px;;
}
.field_meta_info {
	color: #6e99c5;
	font-style: italic;
}
.button_container{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
.field_tips {
	color: green;
	float: right;
}
.field_tips a {
color: green;
}
</style>


</head>
<body>
<h1>${result.title}</h1>
<ul class="nav nav-tabs" role="tablist">
<c:forEach var="scence" items="${result.sceneList}" varStatus="loop">
	<li <c:if test='${scence.selected}'>class="active"</c:if>>
		<a role="tab">${scence.title}${scence.brief}</a>
	</li>
</c:forEach>
</ul>
<div class="cr_content container">
<form role="form"id="cr_form" >
<c:forEach var="group" items="${result.groupList}" varStatus="loop">
	<div class="card">
		<div class="card-title">${group.title }</div>
		<div class="card-body">
		<c:forEach var="field" items="${group.fieldList}" varStatus="loop">
		  <c:choose>
			<c:when test="${group.hidden }">
				<div class="form-group">
				    <label>${field.name }</label>
				    <input type="text" class="form-control" name="${field.name }" value="${field.value }" disabled/>
			  	</div>
			</c:when>
			<c:when test="${field.hidden}">
				<div class="form-group">
				    <label>隐藏字段: ${field.name }</label>
				    <input type="text" class="form-control" name="${field.name }" value="${field.value }" disabled/>
			  	</div>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${field.type == 'prompt_message' }">
						<label style="color: #337ab7;">${field.value }</label>
					</c:when>
					<c:when test="${not empty field.candidateValues }">
						<div class="form-group">
						    <label>${field.label }</label>
						    <span class="field_meta_info"><c:if test="${field.required}"><span style="color:red;">*</span></c:if>
						    	(${field.type}
						    	约束:[${field.minimum } ~ ${field.maximum }]
						    	<c:if test="${field.candidateValuesApi!=null}">获取数据:${ field.candidateValuesApi}</c:if>)
						    </span>
						    <span class="field_tips">
						    	<a href="javascript:void(0)" data-toggle="tooltip" title="${field.tipsContent}">${field.tipsTitle}</a>
						    </span>
						    <select class="form-control" name="${field.name }" value="${field.value }"
						    	<c:if test="${field.disabled }">disabled</c:if>
						    	placeholder="${field.placeholder }">
						    	
						<c:forEach var="i" begin="1" end="${fn:length(field.candidateValues)}" varStatus="loop">
								<c:set var="optData" value="${field.candidateValues[i-1] }"/>
								<option value="${optData.value}"><c:out value="${ optData.title }"/>(${optData.value})</option>
						</c:forEach>
        					</select>
					  	</div>
					</c:when>
					<c:when test="${field.type == 'image' && field.maximum > 1}">
						<label>${field.label }</label>
						    <span class="field_meta_info"><c:if test="${field.required}"><span style="color:red;">*</span></c:if>
						    	(${field.type}
						    	${field.candidateValues }
						    	约束:[${field.minimum } ~ ${field.maximum }]
						    	<c:if test="${field.candidateValuesApi!=null}">获取数据:${ field.candidateValuesApi}</c:if>
						    	)
						    </span>
						    <span class="field_tips">
						    	<a href="javascript:void(0)" data-toggle="tooltip" title="${field.tipsContent}">${field.tipsTitle}</a>
						    </span>
						    
						    <div class="file-loading">
    <input id="${field.name}-file" multiple type="file" accept="image/*">
</div>


<script>
var ${field.name}Data = {};
var ${field.name}Obj = $("#${field.name}-file").fileinput({
        uploadUrl: "/site/upload-file-chunks",
        enableResumableUpload: true,
        maxFileCount: 5,
        theme: 'fas',
        deleteUrl: '/site/file-delete',
        fileActionSettings: {
            showZoom: function(config) {
                if (config.type === 'pdf' || config.type === 'image') {
                    return true;
                }
                return false;
            }
        }
    }).on('fileloaded', function(event, file, previewId, index, reader){
    	var fileName = file.name;
    	${field.name}Data[previewId] = fileName;
    	$("#${field.name }").html(JSON.stringify(toImages(${field.name}Data)));
    }).on('fileremoved', function(event, id, index){
    	delete ${field.name}Data[id];
    	$("#${field.name }").html(JSON.stringify(toImages(${field.name}Data)));
    });
</script>
						    
						    
						    
						    
						    
						    <textarea class="form-control" name="${field.name }" id="${field.name }"
						    	placeholder="${field.placeholder }"
						    	<c:if test="${field.disabled }">disabled</c:if>>${field.value }</textarea>
					</c:when>
					<c:when test="${field.type == 'image' }">
						<label>${field.label }</label>
					    <span class="field_meta_info"><c:if test="${field.required}"><span style="color:red;">*</span></c:if>
					    	(${field.type}
					    	${field.candidateValues }
					    	约束:[${field.minimum } ~ ${field.maximum }]
					    	<c:if test="${field.candidateValuesApi!=null}">获取数据:${ field.candidateValuesApi}</c:if>)
					    </span>
					    <span class="field_tips">
					    	<a href="javascript:void(0)" data-toggle="tooltip" title="${field.tipsContent}">${field.tipsTitle}</a>
					    </span>
					    
					    <div class="file-loading">
   							<input id="${field.name}-file" type="file" accept="image/*"
   							/>
						</div>
						<input id="${field.name}" name="${field.name}" type="text" class="form-control" value='${field.value}' />

						<script>
						$("#${field.name}-file").fileinput({
						        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
						        showUpload: false, //是否显示上传按钮
						        showCaption: true,//是否显示标题
						        browseClass: "btn btn-primary", //按钮样式             
						        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
						}).on('fileloaded', function(event, file, previewId, index, reader) {
						    $('#${field.name}').val('url/store/'+file.name);
						    console.log(file.name);
						});
						</script>
					</c:when>
					<c:otherwise>
						<div class="form-group">
						    <label>${field.label }</label>
						    <span class="field_meta_info"><c:if test="${field.required}"><span style="color:red;">*</span></c:if>
						    	(${field.type}
						    	${field.candidateValues }
						    	约束:[${field.minimum } ~ ${field.maximum }]
						    	<c:if test="${field.candidateValuesApi!=null}">获取数据:${ field.candidateValuesApi}</c:if>)
						    </span>
						    <span class="field_tips">
						    	<a href="javascript:void(0)" data-toggle="tooltip" title="${field.tipsContent}">${field.tipsTitle}</a>
						    </span>
						    <input type="text" class="form-control" name="${field.name }" value="${field.value }" 
						    	placeholder="${field.placeholder }"
						    	<c:if test="${field.disabled }">disabled</c:if>/>
					  	</div>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		  </c:choose>
		</c:forEach>
		<c:if test="${not empty group.actionList }">
			<div class="button_container">
			<c:forEach var="action" items="${group.actionList}" varStatus="loop">
				<button type="button" class="btn btn-primary form_action_button" data-url="${action.linkToUrl }">${action.title }</button>
			</c:forEach>
			</div>
		</c:if>
		</div>
	</div>
</c:forEach>
<div class="button_container">
<c:forEach var="action" items="${result.actionList}" varStatus="loop">
	<button type="button" class="btn btn-primary form_action_button" data-url="${action.linkToUrl }">${action.title }</button>
</c:forEach>
</div>
</form>

<div class="container">
	<a onclick="javascript:$('#json_src').toggle()">点击查看/隐藏JSON数据</a>
	<xmp id="json_src" style="display: none;"><%= com.terapico.utils.DebugUtil.dumpAsJson(request.getAttribute("result"), true)%>
	</xmp>
</div>
</div>
<form id="form4submit" method="post" enctype="application/x-www-form-urlencoded">
	<input name="formData" type="text" style="width: 100%;" id="input4submitFormData"/>
</form>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./bootstrap/jquery.min.js"></script>
    <script src="./bootstrap/jquery-ui.min.js"></script>
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="./scripts/qrcode.js" type="text/javascript"></script>  
<script type="text/javascript">
function formAction() {
	var linkToUrl = $(this).data("url");
	submitForm(linkToUrl);
}
function submitForm(linkToUrl){
	var data = getFormData($("#cr_form")); //自动将form表单封装成json
	$("#input4submitFormData").val(JSON.stringify(data));
	$("#form4submit")[0].action = linkToUrl;
	$("#form4submit")[0].submit();
}
function getFormData($form){
    var unindexed_array = $form.serializeArray();
    $form.find(':input:disabled').each(function(idx, item){
    	unindexed_array.push(item);
    });
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
function toImages(data){
	var list = [];
	for(var key in data){
		var result = {};
		result.title=key;
		result.imageUrl='url/store/' + data[key];
		list.push(result);
	}
	return list;
}
</script>
<script type="text/javascript">
$(function () { 
	$("[data-toggle='tooltip']").tooltip(); 
	$(".form_action_button").click(formAction)

});
</script>
</body>
</html>






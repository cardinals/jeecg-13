<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>投票任务</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div"  action="voteTaskController.do?start">
           
				<div class="form" style="width:600px" >
			      <label class="Validform_label">投票地址:</label>
			      <c:if test="${startTask=='true'}">
			      <input class="inputxt" id="address" name="address"  value="${address}" readonly="readonly"    style="width:300px"/>
			      </c:if>
			     <c:if test="${startTask!='true'}">
			      <input class="inputxt" id="address" name="address"  placeholder="请输入标准的网页地址"   datatype="url"   style="width:300px"/>
			      <span class="Validform_checktip"></span>
			      </c:if>
			    </div> 
			     <div class="form" style="width:600px" >
				      <label class="Validform_label">投票数:</label>
				      <c:if test="${startTask=='true'}">
				        <input class="inputxt" id="votecount" name="votecount"  value="${votecount}" readonly="readonly"    style="width:100px"/>
				      </c:if>
				      <c:if test="${startTask!='true'}">
				        <input class="inputxt" id="votecount" name="votecount"  placeholder="请输入数字"  datatype="n"    style="width:100px"/>
				        <span class="Validform_checktip"></span>
				       </c:if>
				    </div>
				     <div class="form" style="width:600px" >
				      <c:if test="${startTask=='true'}">
				      <c:if test="${code=='0'}">
					      <input id="btnqueryVote"  style="height:30px;width:100px !important;border-radius:5px" onclick="queryVote()" type="button" value="查询投票情况"/>
					      <input id="btnstopsVote"  style="height:30px;width:100px !important;border-radius:5px" onclick="stopVote()" type="button" value="停止投票"/>
				      </c:if>
				      <input id="btnrestartVote"  style="height:30px;width:100px !important;border-radius:5px" onclick="restartVote()" type="button" value="上一步"/>
				      </c:if>
				       <c:if test="${startTask!='true'}">
				       <input id="btnVote"  style="height:30px;width:100px !important;border-radius:5px" onclick="startVote()" type="button" value="开始投票"/>
				       </c:if>
				    </div>
				    <div class="form" style="width:600px" id="showmsg">
				  
				    </div>
				    <input id="taskid" name="taskid" value="${taskid}" type="hidden">
  </t:formvalid>
   <c:if test="${jsonstr!=null}">
    <script type="text/javascript">
     var obj =  $.parseJSON( '${jsonstr}' ); 
     if(obj.code==1){ 
    	 $("#showmsg").append("<span style='color:red'>"+obj.msg+"，返回上一步重新投票！</span>");
     }else{
    	 $("#showmsg").append("<span style='color:red'>"+obj.msg+",开始投票！</span>");
    	 
     }
    
    </script>
  </c:if>
  <script type="text/javascript">
 
  function startVote(){
	  if($(".Validform_wrong").length==0&&$(".Validform_right").length>0){
		  var address = encodeURIComponent(document.getElementById("address").value);
		  window.location.href = "<%=request.getContextPath()%>/voteTaskController.do?start&address="+address+"&votecount="+document.getElementById("votecount").value;
	  }else{
		  return;
	    }
	  }
  
  function queryVote(){
	  
	  $.ajax({
		  url:"<%=request.getContextPath()%>/voteTaskController.do?query&taskid="+document.getElementById("taskid").value, 
			type:"post",
			dataType:"json",
			success:function(data){
				 var obj =  $.parseJSON( data ); 
				$("#showmsg").append("<br/><span style='color:red'>查询成功：已投 票</span>");
			}
		})
  }
  
  function stopVote(){
	  $.ajax({
		  url:"<%=request.getContextPath()%>/voteTaskController.do?end&taskid="+document.getElementById("taskid").value, 
			type:"post",
			dataType:"json",
			success:function(data){
				 var obj =  $.parseJSON( data ); 
				if(obj.code=="1"){
				   $("#showmsg").append("<br/><span style='color:red'>"+obj.msg+"</span>");
				}else if(data.code=="SYS"){
				   $("#showmsg").append("<br/><span style='color:red'>"+obj.content +"</span>");
				}else{
					 $("#showmsg").append("<br/><span style='color:red'>停止成功</span>");
				}
			}
		})
  }
  
  function restartVote(){
	  window.location.href = "<%=request.getContextPath()%>/voteTaskController.do?task";
  }
  </script>
 </body>
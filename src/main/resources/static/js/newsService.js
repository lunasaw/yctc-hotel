//变更为已读
function turnToReaded(newsId){
		newsId+="";
		$.ajax({
			url:"/hotel/restnews/turn-to-readed",
			type:"POST",
			data:newsId,
			contentType:"application/json; charset=utf-8",
			dataType:'json',
			success:function(result){
				if(result.success == false){
					if(result.code == 9002)
						alert("参数非法");
					if(result.code == 9999)
						alert("系统错误");
				}
				else{
					//alert("变更成功");
					//window.location.reload()
				}
			},
			
			error:function(e){
				console.log(e);
				alert("调用失败 ");
			}
		});
	}
//变更为未读
function turnToUnread(newsId){
	newsId+="";
	$.ajax({
		url:"/hotel/restnews/turn-to-unread",
		type:"POST",
		data:newsId,
		contentType:"application/json; charset=utf-8",
		dataType:'json',
		success:function(result){
			if(result.success == false){
				if(result.code == 9002)
					alert("参数非法");
				if(result.code == 9999)
					alert("系统错误");
			}
			else{
				alert("变更成功");
				window.location.reload()
			}
		},
		
		error:function(e){
			console.log(e);
			alert("调用失败 ");
		}
	});
}

//全部变更为已读
function turnAllToReaded() {
	$.ajax({
		url:"/hotel/restnews/turn-all-to-readed",
		type:"POST",
		contentType:"application/json; charset=utf-8",
		dataType:'json',
		success:function(result){
			if(result.success == false){
				if(result.code == 9002)
					alert("参数非法");
				if(result.code == 9999)
					alert("系统错误");
			}
			else{
				alert("变更成功");
				window.location.reload()
			}
		},
		
		error:function(e){
			console.log(e);
			alert("调用失败 ");
		}
	});
}

//全部变更为未读
function turnAllToUnread() {
	$.ajax({
		url:"/hotel/restnews/turn-all-to-unread",
		type:"POST",
		contentType:"application/json; charset=utf-8",
		dataType:'json',
		success:function(result){
			if(result.success == false){
				if(result.code == 9002)
					alert("参数非法");
				if(result.code == 9999)
					alert("系统错误");
			}
			else{
				alert("变更成功");
				window.location.reload()
			}
		},
		
		error:function(e){
			console.log(e);
			alert("调用失败 ");
		}
	});
}

function showNews() {
	$.ajax({
		url:"/hotel/restnews/show-news",
		type:"POST",
		contentType:"application/json; charset=utf-8",
		dataType:'json',
		success:function(result){
			if(result.success == false){
				if(result.code == 9002){
					alert("参数非法");
					return;
				}
				if(result.code == 1006){
					alert("没有新消息");
					return;
				}
				if(result.code == 1007){
					alert("未知消息");
					return;
				}
				if(result.code == 9999){
					alert("系统错误");
					return;
				}
			}
			else{				
				console.log(result.module);
				writeObj(result.module);
			}
		},
		
		error:function(e){
			console.log(e);
			alert("调用失败 ");
		}
	});	
}

function writeObj(obj){ 
	$("#listTable-unread tbody").empty();
	$("#listTable-readed tbody").empty();
	 var noReadList = obj[0];//未读消息
	 var readedList = obj[1];//已读消息
	 if(noReadList.length > 0){
		 for(var i = 0; i < noReadList.length; i++){
			 var listId = i + 1;
			 var deTailUrl = noReadList[i].url;
			 var createTime = new Date(noReadList[i].newsDO.createTime).toJSON();
			 var sendTime = new Date(+new Date(createTime)-21600000).toISOString().replace(/T/g,' ').replace(/.[\d]{3}Z/,' ');//格式、时间差改正
				$("#listTable-unread tbody").append("<tr><th>"+ listId +"</th><td><a href="+deTailUrl+">"+noReadList[i].newsDO.title+"</a></td><td>"+sendTime+"</td></tr>");
			 }
	 }
	 if(readedList.length > 0){
		 for(var i = 0; i < readedList.length; i++){
			 var listId = i + 1;
			 var deTailUrl = readedList[i].url;
			 var createTime = new Date(readedList[i].newsDO.createTime).toJSON();
			 var sendTime = new Date(+new Date(createTime)-21600000).toISOString().replace(/T/g,' ').replace(/.[\d]{3}Z/,' ');//格式、时间差改正
				$("#listTable-readed tbody").append("<tr><th>"+ listId +"</th><td><a href="+deTailUrl+">"+readedList[i].newsDO.title+"</a></td><td>"+sendTime+"</td></tr>");
			 }
	 }
}

function deleteReadedNews() {
	$.ajax({
		url:"/hotel/restnews/delete-all-readed-news",
		type:"POST",
		contentType:"application/json; charset=utf-8",
		dataType:'json',
		success:function(result){
			if(result.success == false){
				if(result.code == 9002){
					alert("参数非法");
					return;
				}else if(result.code == 9999){
					alert("系统错误");
					return;
				}
			}
			else{				
				alert("删除成功");
				window.location.reload()
			}
		},
		
		error:function(e){
			console.log(e);
			alert("调用失败 ");
		}
	});	
}

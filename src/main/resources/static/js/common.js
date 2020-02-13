/**
 * 渲染表格要用到的常用代码封装
 */

// 初始化表格
function initTable(node, pageList, columns) {
    node.bootstrapTable({
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                     //是否显示行间隔色
        cache: false,                      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                  //是否显示分页（*）
        sortable: false,                   //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: 'queryParams',         //传递参数（*）
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: pageList,                 //可供选择的每页的行数（*）
        smartDisplay:false,
        search: true,                      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                 //是否显示所有的列
        showRefresh: true,                 //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,               //是否启用点击选中行
        height: 480,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",               //每一行的唯一标识，一般为主键列
        showToggle:false,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                   //是否显示详细视图
        detailView: false,                 //是否显示父子表
        columns: columns,
        rowStyle: function (row, index) {
            let classesArr = ['info', '#ffffff'];
            let strClass = "";
            if (index % 2 === 0) {  // 偶数行
                strClass = classesArr[0];
            } else {    // 奇数行
                strClass = classesArr[1];
            }
            return { classes: strClass };
        }// 隔行变色
    });
}

// 弹出框
function dialog(message, callback) {
    swal(message, {
        buttons: {
            true: "确定",
            cancel: "取消"
        },
    }).then((value) => {
        switch (value) {
            case "true":
                callback();
                break;
            default:
                break;
        }
    });
}

// 无参数post请求
function noParameterPostRequest(url, callback) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType : "application/json",
        success: function (result) {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9005: swal("错误", "文件删除错误", "error"); break;
                    case 9006: swal("错误", "文件创建错误", "error"); break;
                    case 9007: swal("错误", "文件不存在", "error");   break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
            } else {
                callback(result);
            }
        },
        error: function () {
            swal("错误", "404", "error");
        }
    });
}

// 有参数post请求
function parameterPostRequest(url, data, callback) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        data: JSON.stringify(data),
        traditional: true,
        contentType : "application/json",
        success: function (result) {
            if (result.success === false) {
                switch (result.code) {
                    case 9001: swal("错误", "数据库错误", "error");   break;
                    case 9002: swal("错误", "参数错误", "error");     break;
                    case 9005: swal("错误", "文件删除错误", "error"); break;
                    case 9006: swal("错误", "文件创建错误", "error"); break;
                    case 9007: swal("错误", "文件不存在", "error");   break;
                    case 9999: swal("错误", "系统错误", "error");     break;
                }
            } else {
                callback(result);
            }
        },
        error: function () {
            swal("错误", "404", "error");
        }
    });
}

// 修改提示框样式
function changeToolTip() {
    $(function() {
        $( document ).tooltip({
            position: {
                my: "center bottom-20",
                at: "center top",
                using: function( position, feedback ) {
                    $( this ).css( position );
                    $( "<div>" )
                        .addClass( "arrow" )
                        .addClass( feedback.vertical )
                        .addClass( feedback.horizontal )
                        .appendTo( this );
                }
            },
            show: {
                effect: "slideDown",
                delay: 250
            },
            hide: {
                effect: "explode",
                delay: 250
            }
        });
    });
}

// 移除下拉框所以选项
function removeAllOption(el) {
    el.find("option").remove();
    el.append('<option disabled>--请输入--</option>');
    el.selectpicker('render').selectpicker('refresh');
}

// 设置下拉框success样式
function setSelectSuccess(el) {
    el.selectpicker('setStyle', 'btn-success');
    el.parent().parent().removeClass("has-error");
    el.parent().parent().addClass("has-success");
}

// 设置下拉框error样式
function setSelectError(el) {
    el.selectpicker('setStyle', 'btn-danger');
    el.parent().parent().removeClass("has-success");
    el.parent().parent().addClass("has-error");
}

// 设置input success样式
function setInputSuccess(el) {
    el.parent().parent().removeClass("has-error");
    el.parent().parent().addClass("has-success");
}

// 设置input error样式
function setInputError(el) {
    el.parent().parent().removeClass("has-success");
    el.parent().parent().addClass("has-error");
    el.val("");
}

// UTC时间格式转换
function addZero(num) {
    return num < 10 ? '0' + num : num;
}
function formatDateTime(date) {
    let time = new Date(Date.parse(date));
    let Y = time.getFullYear() + '-';
    let M = this.addZero(time.getMonth() + 1) + '-';
    let D = this.addZero(time.getDate()) + ' ';
    let h = this.addZero(time.getHours()) + ':';
    let m = this.addZero(time.getMinutes()) + ':';
    let s = this.addZero(time.getSeconds());
    return Y + M + D + h + m + s;
}

/**
 * Created by KANYUN on 2017/3/18.
 */
function showUnitExam() {
    $("li a").click(function(){
        var typeCode = $(this).attr('typeCode');
	// alert(typeCode);
        if (typeCode==undefined){
            return;
        }else{
            $("#main").load("unitExam.html");
            $.ajax({
                url : "/cpa/unitExam/showUnitExam.do",
                data : {
                    "typeCode" : typeCode
                },
                type : "POST",
                dataType : "json",
                success : function(result) {
                    if (result.status == 1) {
                        var examData = result.data;
                        for ( var i = 0; i < examData.length; i++) {
                            var examData_stem = examData[i].stem;// 获取题干
                            var examData_options = examData[i].option;// 获取选项
                            var examData_id = examData[i].id;// 获取题目ID
                            var abbreviate = [ "A", "B", "C", "D", "E", "F",
                                "G", "H" ];
                            var s_div = '<div id="stem" class="panel panel-success">';
                            s_div += '<div class="panel-heading">';
                            s_div += '<h3 class="panel-title">' + examData_stem
                                + '</h3>';
                            s_div += '</div>';
                            s_div += '<div id="options" class="panel-body">';
                            s_div += '<div class="radio">';
                            for ( var j = 0; j < examData_options.length; j++) {
                                var examData_option = examData_options[j];
                                s_div += ' <label><input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">'
                                    + examData_option + '</label><br/>';
                            }
                            ;
                            s_div += '</div>';
                            s_div += '</div>';
                            s_div += '</div>';
                            var $examShow = $(s_div);
                            $examShow.data("examData_id", examData_id);
                            $("#examShow").append($examShow);
                        }

                    } else {
                        swal(
                            '提示',
                            '未找到数据!',
                            'info'
                        );
                    }
                },
                error : function() {
                    swal(
                        '错误',
                        '当前请求出错!',
                        'error'
                    );
                }
            })}
    })
}
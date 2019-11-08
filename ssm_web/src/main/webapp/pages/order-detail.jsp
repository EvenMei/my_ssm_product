<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2019-10-25
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,userInfo-scalable=no" name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">

    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/raphael/raphael-min.js"></script>
    <script src="../plugins/morris/morris.min.js"></script>
    <script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../plugins/knob/jquery.knob.js"></script>
    <script src="../plugins/daterangepicker/moment.min.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="../plugins/fastclick/fastclick.js"></script>
    <script src="../plugins/iCheck/icheck.min.js"></script>
    <script src="../plugins/adminLTE/js/app.min.js"></script>
    <script src="../plugins/treeTable/jquery.treetable.js"></script>
    <script src="../plugins/select2/select2.full.min.js"></script>
    <script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="../plugins/ckeditor/ckeditor.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="../plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="../plugins/chartjs/Chart.min.js"></script>
    <script src="../plugins/flot/jquery.flot.min.js"></script>
    <script src="../plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="../plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="../plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $(document).ready(function() {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });


        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }



        $(document).ready(function() {

            // 颜色选取器
            $(".my-colorpicker1").colorpicker();
            $(".my-colorpicker2").colorpicker();

        });




        $(document).ready(function() {
            // 选择框
            $(".select2").select2();
        });




        $(document).ready(function() {

            //Date picker
            $('#datepicker').datepicker({
                autoclose: true,
                language: 'zh-CN'
            });

            // datetime picker
            $('#dateTimePicker').datetimepicker({
                format: "mm/dd/yyyy - hh:ii",
                autoclose: true,
                todayBtn: true,
                language: 'zh-CN'
            });

            //Date range picker
            $('#reservation').daterangepicker({
                locale: {
                    applyLabel: '确认',
                    cancelLabel: '取消',
                    fromLabel: '起始时间',
                    toLabel: '结束时间',
                    customRangeLabel: '自定义',
                    firstDay: 1
                },
                opens: 'left', // 日期选择框的弹出位置
                separator: ' 至 '
                //showWeekNumbers : true,     // 是否显示第几周
            });

            //Date range picker with time picker
            $('#reservationtime').daterangepicker({
                timePicker: true,
                timePickerIncrement: 30,
                format: 'MM/DD/YYYY h:mm A',
                locale: {
                    applyLabel: '确认',
                    cancelLabel: '取消',
                    fromLabel: '起始时间',
                    toLabel: '结束时间',
                    customRangeLabel: '自定义',
                    firstDay: 1
                },
                opens: 'right', // 日期选择框的弹出位置
                separator: ' 至 '
            });

            //Date range as a button
            $('#daterange-btn').daterangepicker({
                    locale: {
                        applyLabel: '确认',
                        cancelLabel: '取消',
                        fromLabel: '起始时间',
                        toLabel: '结束时间',
                        customRangeLabel: '自定义',
                        firstDay: 1
                    },
                    opens: 'right', // 日期选择框的弹出位置
                    separator: ' 至 ',
                    ranges: {
                        '今日': [moment(), moment()],
                        '昨日': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        '最近7日': [moment().subtract(6, 'days'), moment()],
                        '最近30日': [moment().subtract(29, 'days'), moment()],
                        '本月': [moment().startOf('month'), moment().endOf('month')],
                        '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function(start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
            );

        });




        $(document).ready(function() {

            /*table tree*/
            $("#collapse-table").treetable({
                expandable: true
            });

        });




        $(document).ready(function() {

            CKEDITOR.replace('editor1');

            // $(".textarea").wysihtml5({
            //     locale:'zh-CN'
            // });

            $("#markdown-textarea").markdown({
                language: 'zh',
                autofocus: false,
                savable: false
            });

        });



        $(document).ready(function() {

            // 激活导航位置
            setSidebarActive("order-manager");

        });
    </script>
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <%--引入头部导航栏--%>
        <jsp:include page="./header.jsp"/>
    <%--引入头部导航栏--%>

        <%--引入侧边栏--%>
        <jsp:include page="./asidebar.jsp"/>
        <%--引入侧边栏--%>



    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理
                <small>数据表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">

                <!--tab页-->
                <div class="nav-tabs-custom">


                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active" id="tab-label">
                            <h5>订单信息</h5>
                            <div class="row data-type">

                                <div class="col-md-2 title">订单编号</div>
                                <div class="col-md-4 data text">
                                    ${order.id}
                                </div>

                                <div class="col-md-2 title">出发时间</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <label class="form-control pull-right">${order.orderTimeStr}</label>
                                    </div>
                                </div>

                                <div class="col-md-2 title">路线名称</div>
                                <div class="col-md-4 data text">
                                    ${order.product.productName}
                                </div>

                                <div class="col-md-2 title">出发城市</div>
                                <div class="col-md-4 data text">
                                    ${order.product.cityName}
                                </div>

                                <div class="col-md-2 title">下单时间</div>
                                <div class="col-md-4 data ">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <label class="form-control pull-right">${order.orderTimeStr}</label>
                                    </div>
                                </div>


                                <div class="col-md-2 title">出游人数</div>
                                <div class="col-md-4 data text">
                                    ${order.peopleCount}
                                </div>


                                <div class="col-md-2 title rowHeight2x">其他信息</div>
                                <div class="col-md-10 data rowHeight2x">
                                    <textarea class="form-control" rows="3" placeholder="请输入..."disabled="disabled">
                                        ${order.orderDesc}
                                    </textarea>
                                </div>

                            </div>


                        </div>
                        <!--label显示的内容/-->

                    </div>
                    <!--tab内容/-->



                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">旅客信息</h3>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example2" class="table table-bordered table-hover">
                                            <thead>
                                            <tr>
                                                <th>人群</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>手机号</th>
                                                <th>证件类型</th>
                                                <th>证件号</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${order.travellers}"  var="traveller"  varStatus="s">

                                            <tr>
                                                <td>${traveller.travellerType}</td>
                                                <td>${traveller.name}</td>
                                                <td>${traveller.sex}</td>
                                                <td>${traveller.phoneNum}</td>
                                                <td>${traveller.credentialsType}</td>
                                                <td>${traveller.credentialsNum}</td>
                                            </tr>

                                            </c:forEach>



                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->


                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </section>




                        <!--tab内容-->
                        <div class="tab-content">

                            <!--label显示的内容-->
                            <div class="tab-pane active" id="tab-label2">
                                <h5>联系人信息</h5>
                                <div class="row data-type">

                                    <div class="col-md-2 title">会员</div>
                                    <div class="col-md-4 data text">
                                        ${order.member.nickName}
                                    </div>

                                    <div class="col-md-2 title">联系人</div>
                                    <div class="col-md-4 data text">
                                        ${order.member.name}
                                    </div>

                                    <div class="col-md-2 title">手机号</div>
                                    <div class="col-md-4 data text">
                                        ${order.member.phoneNum}
                                    </div>

                                    <div class="col-md-2 title">邮箱</div>
                                    <div class="col-md-4 data text">
                                        ${order.member.email}
                                    </div>

                                </div>
                            </div>
                            <!--label显示的内容/-->
                        </div>
                        <!--tab内容/-->


                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active" id="tab-label3">
                            <h5>联系人信息</h5>
                            <div class="row data-type">

                                <div class="col-md-2 title">支付方式</div>
                                <div class="col-md-4 data text">
                                    ${order.payTypeStr}
                                </div>

                                <div class="col-md-2 title">产品价格</div>
                                <div class="col-md-4 data">
                                    <div class="input-group">
                                        <span class="input-group-addon">¥</span>
                                        <input type="text" class="form-control" name="productPrice" disabled="disabled" value="${order.product.productPrice}">
                                        <span class="input-group-addon">.00</span>
                                    </div>
                                </div>



                            </div>
                        </div>
                        <!--label显示的内容/-->
                    </div>
                    <!--tab内容/-->






                </div>
                <!--tab页/-->










                <!-- .box-footer
    <div class="box-footer"></div>
    -->
                <!-- /.box-footer-->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a href="http://www.itcast.cn">研究院研发部</a>.</strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->

</div>



</body>
</html>

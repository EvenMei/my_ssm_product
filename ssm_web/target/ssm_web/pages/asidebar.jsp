<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2019-10-22
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>




</head>

<body class="hold-transition skin-purple sidebar-mini">

    <!-- 导航侧栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>EvenMei</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <!-- search form -->
            <!--<form action="#" method="get" class="sidebar-form">
        <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="搜索...">
            <span class="input-group-btn">
            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
            </button>
          </span>
        </div>
    </form>-->
            <!-- /.search form -->


            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">菜单</li>

                <li id="main"><a href="/product/main.do"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

                <!-- 菜单 -->


                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-folder"></i> <span>系统管理</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">

                        <li id="user-manager">
                            <a href="/userInfo/findAll.do">
                                <i class="fa fa-circle-o"></i> 用户管理
                            </a>
                        </li>

                        <li id="role-manager">
                            <a href="/role/findAll.do">
                                <i class="fa fa-circle-o"></i> 角色管理
                            </a>
                        </li>

                        <li id="permission-manager">
                            <a href="/permission/findAll.do">
                                <i class="fa fa-circle-o"></i> 资源权限管理
                            </a>
                        </li>

                        <li id="admin-500">
                            <a href="all-admin-500.html">
                                <i class="fa fa-circle-o"></i> 访问日志
                            </a>
                        </li>




                    </ul>
                </li>



                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i> <span>基础数据</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">

                        <li id="product-manager">
                                 <a href="/product/findAll.do?pageNum=1&pageSize=4">
                                <i class="fa fa-circle-o"></i> 产品管理
                            </a>
                        </li>

                        <li id="order-manager">
                            <a href="/orders/findAll.do">
                                <i class="fa fa-circle-o"></i> 订单管理
                            </a>
                        </li>



                    </ul>
                </li>


            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- 导航侧栏 /-->

</body>

</html>
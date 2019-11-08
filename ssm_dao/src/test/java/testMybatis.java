import com.meiyukai.ssm.dao.*;
import com.meiyukai.ssm.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class testMybatis {

    @Resource(name = "productDao")
    private IProductDao productDao;


    @Resource(name = "travellerDao")
    private ITravellerDao travellerDao;

    @Resource(name = "orderDao")
    private IOrderDao orderDao;

    @Resource(name = "memberDao")
    private IMemeberDao memberDao;

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Resource(name = "permissionDao")
    private IPermissionDao permissionDao;

    @Resource(name = "roleDao")
    private IRoleDao roleDao;




    /**
     * 测试查询 product  中的数据
     */

    @Test
    public void test01(){

        List<Product> products = productDao.findAll();
        for(Product product:products){
            System.out.println("product: "  + product);
        }
    }

    /**
     * 测试向数据库中保存数据
     */
    @Test
    public void test02(){
        Product product = new Product();
        product.setId("abcdefgjijklmnopqrst");
        product.setProductNum("ssm02");
        product.setProductName("travel to naning");
        product.setCityName("nanjing");
        product.setDepartureTime(new Date());
        product.setProductDesc("happy jounery");
        product.setProductStatus(1);
        product.setProductPrice(2000.0);
        productDao.save(product);
    }

    /**
     * 测试删除 product
     */

    @Test
    public void test03(){
        productDao.delete("abcdefgjijklmnopqrst");
    }


    /**
     * 测试根据memberId 查询Member
     */

    @Test
    public void testMemberDao(){
        Member member = memberDao.findMemberById("BADFEASD798AFSASD");
        System.out.println("member    :    " + member);
    }

    /**
     * 测试 根据orderId 查询 所有的  traveller
     */
    @Test
    public void testFindTravellersByOrderId(){
        List<Traveller> travellers = travellerDao.findTravellerByOrderId("1DC797C486290E8713CA3C6ECCC");
        for(Traveller traveller :  travellers ){
            System.out.println("traveller :  " + traveller );
        }
    }



    @Test
    public void test04(){
        List<Orders> orders = orderDao.findAll();
        for(Orders o: orders ){
            System.out.println("id   ------  " + o.getId());
            System.out.println("orderNum  ------ " + o.getOrderNum());
            System.out.println("orderTime ------" + o.getOrderTimeStr()  );
            System.out.println("peopleCount  ---- " + o.getPeopleCount());
            System.out.println("orderDesc   ---  ---- " + o.getOrderDesc());
            System.out.println("payType    -----   " + o.getPayTypeStr());
            System.out.println("orderStatus     -----  " + o.getOrderStatusStr());
            System.out.println("product -----  " + o.getProduct());
            System.out.println("member ----  "+ o.getMember());
            System.out.println("travellers  -----   " + o.getTravellers());
            System.out.println("=============================================================");
        }
    }

    @Test
    public void testFindzOrderById(){
        Orders o =  orderDao.findOrdersById("1DC797C486290E8713CA3C6ECCC");
        System.out.println("id   ------  " + o.getId());
        System.out.println("orderNum  ------ " + o.getOrderNum());
        System.out.println("orderTime ------" + o.getOrderTimeStr()  );
        System.out.println("peopleCount  ---- " + o.getPeopleCount());
        System.out.println("orderDesc   ---  ---- " + o.getOrderDesc());
        System.out.println("payType    -----   " + o.getPayTypeStr());
        System.out.println("orderStatus     -----  " + o.getOrderStatusStr());
        System.out.println("product -----  " + o.getProduct());
        System.out.println("member ----  "+ o.getMember());
        System.out.println("travellers  -----   " + o.getTravellers());
    }

    @Test
    public void testFindTotalCountFromProduct(){
        Double totalCount = productDao.getTotalCount();
        System.out.println("totalCount ---  " + totalCount);
    }


    @Test
    public void testCommon(){

        double ceil = 6.0/4;
        System.out.print(Math.ceil(ceil));
    }


    @Test
    public void testFindAllUsers(){
        List<UserInfo> userInfos = userDao.findAll();
        for(UserInfo userInfo : userInfos){
            System.out.println("------id------"  + userInfo.getId());
            System.out.println("------username------"+  userInfo.getUsername()) ;
            System.out.println("--------password--------" + userInfo.getPassword() );
            System.out.println("-------email----- "  + userInfo.getEmail() );
            System.out.println("------phoneNum-------"+ userInfo.getPhoneNum());
            System.out.println("-----------statusStr-----------"+ userInfo.getStatusStr());
            System.out.println("------------roles----------------- " +  userInfo.getRoles());
            System.out.println("========================================================");
        }
    }


    @Test
    public void testFindAllPermissionDao(){
        List<Permission> permissions = permissionDao.findAll();
        for(Permission permission : permissions){
            System.out.println("permission : " + permission);
        }
    }

    @Test
    public void testFindAllRole(){
        List<Role> roles  = roleDao.findAll();
        for(Role role: roles){
            System.out.println("role :  "  + role) ;
        }
    }

    @Test
    public void testFindUserById(){
        UserInfo userInfo = userDao.findUserById("9790d98297994651968b0b621f6186dd");
        System.out.println("Userinfo :  " + userInfo);
    }

    @Test
    public void testFindRoleByUserId(){
        List<Role> roles = roleDao.findRoleByUserId("9790d98297994651968b0b621f6186dd");
        for(Role role : roles){
            System.out.println("role   :  " + role);
        }
    }

    @Test
    public void testFindPermissionByRoleId(){
        List<Permission> permissions = permissionDao.findPermissionByRoleId("r01");
        for(Permission permission :  permissions){
            System.out.println("permission's size is   : "   + permissions.size());
            System.out.println("   permissions :  " + permission);
        }
     }

     @Test
     public void testFindPermission(){
         List<Permission> permissions = permissionDao.findPermissionByRoleId("r01");
         for(Permission permission:  permissions){
             System.out.println("permission :   "  + permission);
         }

     }


     @Test
     public void testFindUserByRoleId(){
        List<UserInfo> userInfos = userDao.findUserByRoleId("r01");
        for(UserInfo userInfo : userInfos){
            System.out.println("userInfo    : "  + userInfo);
        }
     }

     @Test
     public void testFindUserByUserName(){
        UserInfo userInfo =  userDao.findUserByUserName("meiyukai");
        System.out.println("userInfo  : " + userInfo);
     }


}

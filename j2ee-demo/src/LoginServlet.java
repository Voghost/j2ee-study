import sun.rmi.runtime.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试 servlet
 * <p>
 * Servlet 生命周期测试:
 * 1. 构造防范
 * 2. 初始化函数 init
 * 3. 业务逻辑代码 service / doPost / doGet / ...
 * 4. 销毁servlet destory
 */
public class LoginServlet extends HttpServlet {

    /**
     * 构造方法
     * Servlet 是单实例的
     * 无论被网页引用多少次，都只被调用一次
     */
    public LoginServlet() {
        System.out.println("1. ============ 构造 =========  函数");
        System.out.println("LoginServlet 构造方法 被调用");
    }


    /**
     * 初始化 init
     *
     * @param config
     */
    @Override
    public void init(ServletConfig config) {
        System.out.println("2. ============ init =========  函数");
        System.out.println("初始化函数");
        System.out.println("init(ServletConfig)");
    }


    /*
     * 重写 service
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("3. ========== service ============= 函数");

        /**
         * 中文乱码，设置编码
         */
        request.setCharacterEncoding("UTF-8"); //request(请求) 编码
        response.setContentType("text/html;charset=UTF-8"); //response(响应) 编码

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (name.equals("admin") && password.equals("admin")) { //密码正确
            /**
             * 服务器内跳转
             */
            request.getRequestDispatcher("success.html").forward(request, response);
        } else { //密码错误
            /**
             * 客户端中跳转
             */
            response.sendRedirect("fail.html");
        }
    }


    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("4. ============= destroy ============ 函数");
        System.out.println("destroy 执行");
    }


    /**
     * 垃圾回收
     */


}

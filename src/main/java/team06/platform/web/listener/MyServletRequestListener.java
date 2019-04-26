package team06.platform.web.listener;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyServletRequestListener implements ServletRequestListener {
    private IApplicationService applicationService = new ApplicationServiceImpl();
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
//        System.out.println(servletRequestEvent.getServletRequest() + "销毁了！！");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
//        System.out.println("1 context pathinfo is:" + request.getPathInfo());
        System.out.println("context URI is:" + request.getRequestURI());

        String pattern = "(/app/\\w+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(request.getRequestURI());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0));
            applicationService.increaseVisitByContext(m.group(0));
        }
//        System.out.println("2 context Header is:" + request.getHeader("Referer"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        System.out.println(servletRequestEvent.getServletRequest() + "创建了！！");
    }
}

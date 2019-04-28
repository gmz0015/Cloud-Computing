package team06.platform.web.listener;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyServletRequestListener implements ServletRequestListener, HttpSessionListener {
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private Object lock = new Object();

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent){
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
//        System.out.printf("[%-23s] Destroy URI: %s\n", new Timestamp(new Date().getTime()), request.getRequestURI());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
//        System.out.printf("[%-23s] Initialize URI: %s\n", new Timestamp(new Date().getTime()), request.getRequestURI());

//        if (request.getRequestURI().equals("/")) {
//            synchronized (lock) {
//
//                IncreaseCountThread increaseCountThread = new IncreaseCountThread(request.getRequestURI(), lock);
//                increaseCountThread.start();
//            }
//        }

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
//        System.out.printf("[%-23s] Create Session: %s\n", new Timestamp(new Date().getTime()), servletContext);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
//        System.out.printf("[%-23s] Destroy Session: %s\n", new Timestamp(new Date().getTime()), servletContext);

        Object object = servletContext.getAttribute("userCount");
        if (object != null){
            int num = (int) object;
            servletContext.setAttribute("userCount", num - 1);
        }
    }

    class IncreaseCountThread extends Thread{
        private String URI;
        private Object lock;

        public IncreaseCountThread(String URI, Object lock){
            this.URI = URI;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {

            }
        }
    }
}

package team06.platform.web.listener;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyServletRequestListener implements ServletRequestListener {
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private Object lock = new Object();

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent){
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.printf("[%-23s] Destroy URI: %s\n", new Timestamp(new Date().getTime()), request.getRequestURI());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.printf("[%-23s] Initialize URI: %s\n", new Timestamp(new Date().getTime()), request.getRequestURI());

        synchronized (lock) {

            CountThread countThread = new CountThread(request.getRequestURI(), lock);
            countThread.start();
        }
    }

    class CountThread extends Thread{
        private String URI;
        private Object lock;

        public CountThread(String URI, Object lock){
            this.URI = URI;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                String pattern = "(/app/\\w+)";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(this.URI);
                if (m.find( )) {
                    if (m.group(0).equals("/app/null")) {
                        System.out.println("Find Null");
                    }else {
                        if (m.group(0).equals("/app/j_security_check")) {
                            System.out.println("Security Check");
                        }else {
                            System.out.printf("[%-23s] Count URI: %s\n", new Timestamp(new Date().getTime()), m.group(0));
                            applicationService.increaseVisitByContext(m.group(0));
                        }
                    }
                }
            }
        }
    }
}

package team06.platform.web.bean;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CountBean {
    private Object lock = new Object();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doCount(String contextPath) {
        synchronized (lock) {
            CountBean.CountThread countThread = new CountBean.CountThread(contextPath, lock);
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
                System.out.printf("[%-23s] Count URI: %s\n", new Timestamp(new Date().getTime()), this.URI);
                applicationService.increaseVisitByContext(this.URI);
            }
        }
    }
}

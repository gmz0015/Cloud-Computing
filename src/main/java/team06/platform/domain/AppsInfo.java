package team06.platform.domain;

/**
 * For AdminBean.java
 * Store the context paths, current status, number of active sessions and folder name for applications
 */
public class AppsInfo {
    private String contextPath;
    private String status;
    private String sessions;
    private String folderName;

    public AppsInfo(String contextPath, String status, String sessions, String folderName) {
        this.contextPath = contextPath;
        this.status = status;
        this.sessions = sessions;
        this.folderName = folderName;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}

package config.beans;

public class WebDriverConfigurationBean {

    private String binaryLocation;
    private String neverAskSaveToDisk;
    private Boolean showDownloadManagerOnStart;
    private Integer downloadFolderList;
    private Integer implicitWait;

    public Integer getDownloadFolderList() {
        return downloadFolderList;
    }

    public void setDownloadFolderList(Integer downloadFolderList) {
        this.downloadFolderList = downloadFolderList;

    }

    public String getBinaryLocation() {
        return binaryLocation;
    }

    public void setBinaryLocation(String binaryLocation) {
        this.binaryLocation = binaryLocation;
    }

    public String getNeverAskSaveToDisk() {
        return neverAskSaveToDisk;
    }

    public void setNeverAskSaveToDisk(String neverAskSaveToDisk) {
        this.neverAskSaveToDisk = neverAskSaveToDisk;
    }

    public Integer getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(Integer implicitWait) {
        this.implicitWait = implicitWait;
    }

    public Boolean getShowDownloadManagerOnStart() {
        return showDownloadManagerOnStart;
    }

    public void setShowDownloadManagerOnStart(Boolean showDownloadManagerOnStart) {
        this.showDownloadManagerOnStart = showDownloadManagerOnStart;
    }
}

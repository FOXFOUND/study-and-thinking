package com.foxfound.log.vo;

/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-01-14
 */
public class EncryptDataVO {
    private String encryptedData;
    private String iv;
    private String sessionKey;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}

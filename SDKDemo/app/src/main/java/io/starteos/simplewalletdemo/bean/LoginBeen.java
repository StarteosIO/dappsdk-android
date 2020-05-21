package io.starteos.simplewalletdemo.bean;

/**
 * Login parameter entity
 *
 * @author ggband
 */
public class LoginBeen {

    private String protocol;      // 协议名，钱包用来区分不同协议，本协议为 SimpleWallet
    private String version;   // 协议版本信息，如1.0
    private String dappName;   // dapp名字，用于在钱包APP中展示
    private String dappIcon;   // dapp图标Url，用于在钱包APP中展示
    private String action;   // 赋值为login
    private String uuID;   // dapp生成的，用于dapp登录验证唯一标识
    private String loginUrl;   // dapp server生成的，用于接受此次登录验证的URL
    private String loginMemo;   // 登录的备注信息，钱包用来展示，可选
    private long expired;//过期时间，unix时间戳
    private String callback;   // 用户完成操作后，钱包回调拉起dapp移动端的回调URL,如appABC://abc.com?action=login，可选
    // 钱包回调时在此URL后加上操作结果(&result)，如：appABC://abc.com?action=login&result=1,
    // result的值为：0为用户取消，1为成功,  2为失败


    public LoginBeen() {
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDappName() {
        return dappName;
    }

    public void setDappName(String dappName) {
        this.dappName = dappName;
    }

    public String getDappIcon() {
        return dappIcon;
    }

    public void setDappIcon(String dappIcon) {
        this.dappIcon = dappIcon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUuID() {
        return uuID;
    }

    public void setUuID(String uuID) {
        this.uuID = uuID;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLoginMemo() {
        return loginMemo;
    }

    public void setLoginMemo(String loginMemo) {
        this.loginMemo = loginMemo;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}

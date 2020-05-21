package io.starteos.simplewalletdemo.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <description>
 * 自定义合约Bean
 * <p>
 * author: rabbertu
 */
public class ContractBean {

    private String protocol;       // 协议名，钱包用来区分不同协议，本协议为 SimpleWallet
    private String version;   // 协议版本信息，如1.0
    private String action;   // 自定义合约，transaction
    private String dappName;   // dapp名字，用于在钱包APP中展示，可选
    private String dappIcon;   // dapp图标Url，用于在钱包APP中展示，可选
    private String from;   // 根据该字段查找本地钱包
    private List<ContractAction> actions = new ArrayList();   //合约调用参数
    private String desc;   // 说明信息，最长不要超过128个字节，可选
    private String fromAddress;   // 指定签名公钥，可选
    private List<SignAccount> actors = new ArrayList();    // 设置签名账号及权限，可选
    private long expired;//过期时间，unix时间戳
    private String callback;   // 用户完成操作后，钱包回调拉起dapp移动端的回调URL,如appABC://abc.com?action=login，可选
    // 钱包回调时在此URL后加上操作结果(result、txID)，如：appABC://abc.com?action=login&result=1&txID=xxx,
    // result的值为：0为用户取消，1为成功,  2为失败；txID为EOS主网上该笔交易的id（若有）
    private boolean isPush; //是否push交易


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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<SignAccount> getActors() {
        return actors;
    }

    public void setActors(List<SignAccount> actors) {
        this.actors = actors;
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

    public List<ContractAction> getActions() {
        return actions;
    }

    public void setActions(List<ContractAction> actions) {
        this.actions = actions;
    }

    public boolean isPush() {
        return isPush;
    }

    public void setPush(boolean push) {
        isPush = push;
    }


    public static class ContractAction {
        public String contract; //合约地址
        public String action; //合约方法
        public Map<String, Object> data = new HashMap();//合约需要的参数，
    }

    public static class SignAccount {
        public String actor;
        public String permission;
    }
}

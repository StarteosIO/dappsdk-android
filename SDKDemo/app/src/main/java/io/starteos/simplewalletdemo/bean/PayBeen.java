package io.starteos.simplewalletdemo.bean;


/**
 * Transfer parameter entity
 *
 * @author ggband
 */
public class PayBeen {

    private String protocol;       // 协议名，钱包用来区分不同协议，本协议为 SimpleWallet
    private String version;   // 协议版本信息，如1.0
    private String action;   // 支付时，赋值为transfer
    private String dappName;   // dapp名字，用于在钱包APP中展示，可选
    private String dappIcon;   // dapp图标Url，用于在钱包APP中展示，可选
    private String from;   // 付款人的EOS账号，可选
    private String to;   // 收款人的EOS账号，必须
    private String amount;   // 转账数量，必须
    private String contract;   // 转账的token所属的contract账号名
    private String symbol;   // 转账的token名称，必须
    private String precision;   // 转账的token的精度，小数点后面的位数，必须
    private String dappData;   // 由dapp生成的业务参数信息，需要钱包在转账时附加在memo中发出去，格式为:k1=v1&k2=v2，可选
    // 钱包转账时还可附加ref参数标明来源，如：k1=v1&k2=v2&ref=walletname
    private String desc;   // 交易的说明信息，钱包在付款UI展示给用户，最长不要超过128个字节，可选
    private long expired;//过期时间，unix时间戳
    private String callback;   // 用户完成操作后，钱包回调拉起dapp移动端的回调URL,如appABC://abc.com?action=login，可选
    // 钱包回调时在此URL后加上操作结果(result、txID)，如：appABC://abc.com?action=login&result=1&txID=xxx,
    // result的值为：0为用户取消，1为成功,  2为失败；txID为EOS主网上该笔交易的id（若有）


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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getDappData() {
        return dappData;
    }

    public void setDappData(String dappData) {
        this.dappData = dappData;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

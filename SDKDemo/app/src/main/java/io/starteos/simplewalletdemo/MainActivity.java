package io.starteos.simplewalletdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.starteos.simplewalletdemo.bean.ContractBean;
import io.starteos.simplewalletdemo.bean.LoginBeen;
import io.starteos.simplewalletdemo.bean.PayBeen;

/**
 * main page
 * Protocol address:
 * https://github.com/southex/SimpleWallet
 * Starteos package name:com.hconline.iso
 * 1、auth login
 * 2、auth transfer
 *
 * @author ggband
 */
public class MainActivity extends AppCompatActivity {

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Perform login
     *
     * @param view
     */
    public void onAuthLogin(View view) {
        String url = Contant.STARTEOS_AUTH_URI + "?param=" + buildLoginParams();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intent);
    }

    /**
     * Build login parameters
     *
     * @return Parameters required for login
     */
    private String buildLoginParams() {

        LoginBeen loginBeen = new LoginBeen();
        loginBeen.setAction("login");
        loginBeen.setProtocol("SimpleWallet");
        loginBeen.setVersion("1.0");
        loginBeen.setDappName("your dappName");
        loginBeen.setDappIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1574764368&di=b97e838981fc4f86f7e4314cb599cc07&src=http://pic.51yuansu.com/pic3/cover/03/58/86/5bd0ffe48d6fa_610.jpg");
        loginBeen.setUuID("android-537cb55572e14bda9c30aa4119eb3dd5");
        //Server login address of the project party
        loginBeen.setLoginUrl("https://newdex.340wan.com/api/account/walletVerify");
        loginBeen.setLoginMemo("LoginMemo");
        loginBeen.setExpired(System.currentTimeMillis() + 1000 * 3);
        loginBeen.setCallback(Contant.TRANSFER_SUCCESS_URI + "?action=login");
        return gson.toJson(loginBeen);
    }


    /**
     * Execution of transfer
     *
     * @param view
     */
    public void onAuthTransfer(View view) {
        String url = Contant.STARTEOS_AUTH_URI + "?param=" + buildTransferParams();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intent);
    }

    /**
     * Build transfer parameters
     *
     * @return Parameters required for transfer
     */
    private String buildTransferParams() {

        PayBeen payBeen = new PayBeen();
        payBeen.setAction("transfer");
        payBeen.setAmount("0.0001");
        payBeen.setContract("eosio.token");
        payBeen.setDesc("transfer desc");
        payBeen.setFrom("starteosio11");
        payBeen.setTo("accounttry33");
        payBeen.setPrecision("4");
        payBeen.setSymbol("EOS");
        payBeen.setDappData("memo");
        payBeen.setProtocol("SimpleWallet");
        payBeen.setVersion("1.0");
        payBeen.setExpired(System.currentTimeMillis() + 1000 * 3);
        payBeen.setDappName("your dappName");
        payBeen.setDappIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1574764368&di=b97e838981fc4f86f7e4314cb599cc07&src=http://pic.51yuansu.com/pic3/cover/03/58/86/5bd0ffe48d6fa_610.jpg");
        payBeen.setCallback(Contant.TRANSFER_SUCCESS_URI + "?action=transfer");
        return gson.toJson(payBeen);
    }

    /**
     * Execution of contract
     *
     * @param view
     */
    public void onAuthContract(View view) {
        String url = Contant.STARTEOS_AUTH_URI + "?param=" + buildContractParams();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intent);
    }

    /**
     * Build contract parameters
     *
     * @return Parameters required for contract
     */
    private String buildContractParams() {

        ContractBean contractBean = new ContractBean();
        contractBean.setAction("transaction");
        contractBean.setDesc("购买战马");//界面上给用户展示的说明
        contractBean.setFrom("starteosio11");//调用合约的账号名
//        contractBean.setFromAddress("EOSxxx");//如果不设置则默认会选择from账号下合适的私钥进行签名，如果设置，则优先会找from账号下fromAddress公钥对应的私钥进行签名
        List<ContractBean.ContractAction> actions = new ArrayList<>();//合约，支持多个合约调用
        ContractBean.ContractAction action = new ContractBean.ContractAction();
        action.contract = "eosio.token";//合约地址
        action.action = "transfer";//合约方法
        action.data.put("from", "starteosio11");//合约需要的参数，value是Object类型，传参是请注意类型，转换成json字符串后能够正确的调用合约
        action.data.put("to", "starteosio22");
        action.data.put("quantity", "0.0001 EOS");
        action.data.put("memo", "test");
        actions.add(action);
        contractBean.setActions(actions);
//        contractBean.setPush(false);//是否代付， 注意⚠️：如果传了fromAddress该字段，则starteos不会自动为该交易做代付
        contractBean.setProtocol("SimpleWallet");
        contractBean.setVersion("1.0");
        contractBean.setExpired(System.currentTimeMillis() + 1000 * 3);
        contractBean.setDappName("your dappName");
        contractBean.setDappIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1574764368&di=b97e838981fc4f86f7e4314cb599cc07&src=http://pic.51yuansu.com/pic3/cover/03/58/86/5bd0ffe48d6fa_610.jpg");
        contractBean.setCallback(Contant.TRANSFER_SUCCESS_URI + "?action=transaction");
        return gson.toJson(contractBean);
    }

    /**
     * Execution of contract
     *
     * @param view
     */
    public void onAuthActor(View view) {
        String url = Contant.STARTEOS_AUTH_URI + "?param=" + buildMutilSignParams();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intent);
    }

    /**
     * Build contract parameters
     *
     * @return Parameters required for contract
     */
    private String buildMutilSignParams() {

        ContractBean contractBean = new ContractBean();
        contractBean.setAction("transaction");
        contractBean.setDesc("购买战马");//界面上给用户展示的说明
        contractBean.setFrom("starteosio11");//调用合约的账号名
//        contractBean.setFromAddress("EOSxxx");//如果不设置则默认会选择from账号下合适的私钥进行签名，如果设置，则优先会找from账号下fromAddress公钥对应的私钥进行签名
        List<ContractBean.ContractAction> actions = new ArrayList<>();//合约，支持多个合约调用
        ContractBean.ContractAction action = new ContractBean.ContractAction();
        action.contract = "eosio.token";//合约地址
        action.action = "transfer";//合约方法
        action.data.put("key", "value");//合约需要的参数，value是Object类型，传参是请注意类型，转换成json字符串后能够正确的调用合约
        actions.add(action);
        contractBean.setActions(actions);
        List<ContractBean.SignAccount> actors = new ArrayList<>();//多签
        ContractBean.SignAccount signAccount = new ContractBean.SignAccount();
        signAccount.actor = "starteosio11";
        signAccount.permission = "active";
        ContractBean.SignAccount signAccount2 = new ContractBean.SignAccount();
        signAccount2.actor = "accounttry33";
        signAccount2.permission = "active";
        actors.add(signAccount);
        actors.add(signAccount2);
        contractBean.setActors(actors);
        contractBean.setProtocol("SimpleWallet");
        contractBean.setVersion("1.0");
        contractBean.setExpired(System.currentTimeMillis() + 1000 * 3);
        contractBean.setDappName("your dappName");
        contractBean.setDappIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1574764368&di=b97e838981fc4f86f7e4314cb599cc07&src=http://pic.51yuansu.com/pic3/cover/03/58/86/5bd0ffe48d6fa_610.jpg");
        contractBean.setCallback(Contant.TRANSFER_SUCCESS_URI + "?action=transaction");
        return gson.toJson(contractBean);
    }

}

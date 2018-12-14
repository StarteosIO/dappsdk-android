# Starteos Android DApp SDK Document
## 集成
使用gradle引入sdk
```gradle
api 'io.starteos:dappsdk-native:1.0.7'
```
并且在AndroidManifest.xml中配置
```xml
<activity
    android:name="io.starteos.dappsdk.android.lib.ProxyActivity"
    android:theme="@style/transparentActivity" />
```
## 错误码
```json
 10000 -> 成功
-10003 -> params错误
-10004 -> 用户取消了操作
-10005 -> 当前没有钱包
-10006 -> 网络错误
-10007 -> 交易失败
-10008 -> 没有找到转出的钱包
-10009 -> 没有安装Starteos钱包
```

## 使用
### 登录
`调用：`
```kotlin
StarteosSDKHelper.getInstance().execute(this, StarteosLoginEntity("test"), object : StarteosSDKListener {
    override fun success(result: JSONObject?) {
    }

    override fun error(code: Int, message: String?) {
    }
})
```
`结果:`
```json
{
	"accountName": "visualvisual",
	"accountAddress": "EOS6k6yWS3mPbQ7AhdfSdvxHPFaJfCe2yFSWsaNK1oioMJq92ccbm"
}
```
`注意：`
如果登录过，第二次调用登录方法的时候返回上次登录缓存的数据，如果想要每次都拉起钱包重新登录，则需要在此方法之前调用退出登录的方法。
当转账或自定义合约调用的时候返回-10008，代表用户登录信息失效，此时SDK会清空登录的缓存数据，DApp需要处理此错误，重新调用登录方法。
### 转账
`调用：`
```kotlin
val entity = StarteosTransferEntity("test")
entity.from = "visualvisual"//转出使用的钱包，从登录方法获取
entity.fromAddress = "EOS6k6yWS3mPbQ7AhdfSdvxHPFaJfCe2yFSWsaNK1oioMJq92ccbm"//转出使用的公钥，从登录方法获取
entity.to = "developer.x"//接收账号
entity.amount = BigDecimal("0.0001")//注意这里使用String来构造BigDicemal，否则可能出现精度问题
entity.contract = "aircoin.eos"//代币合约地址
entity.symbol = "AC"//代币单位
entity.memo = "memo"//转账备注
entity.hint = "for test"//界面上展示给用户的说明
StarteosSDKHelper.getInstance().execute(this, entity, object : StarteosSDKListener {
    override fun success(result: JSONObject?) {
    }

    override fun error(code: Int, message: String?) {
        //当code==-10007时，message为链上原始错误信息
    }
})
```
`结果:`
```json
{
	"transaction_id": "c564e82c4d0e3c3c781d162c333bede9d83a86ad82c53d23a45fb55c9ff81381",
	"processed": {
		"id": "c564e82c4d0e3c3c781d162c333bede9d83a86ad82c53d23a45fb55c9ff81381",
		"block_num": 26850202,
		"block_time": "2018-11-14T06:27:33.000",
		"producer_block_id": null,
		"receipt": {
			"status": "executed",
			"cpu_usage_us": 530,
			"net_usage_words": 17
		},
		"elapsed": 530,
		"net_usage": 136,
		"scheduled": false,
		"action_traces": [{
			"receipt": {
				"receiver": "aircoin.eos",
				"act_digest": "f09112caec978b647defbc459656b87b1eaf04e1f4ec9c2a10f47d009bfdf592",
				"global_sequence": 1579377540,
				"recv_sequence": 13104,
				"auth_sequence": [
					["visualvisual", 1699]
				],
				"code_sequence": 1,
				"abi_sequence": 1
			},
			"act": {
				"account": "aircoin.eos",
				"name": "transfer",
				"authorization": [{
					"actor": "visualvisual",
					"permission": "active"
				}],
				"data": {
					"from": "visualvisual",
					"to": "developer.x",
					"quantity": "0.0001 AC",
					"memo": "memo"
				},
				"hex_data": "108dc66e47a3b1db003ab8aad2a8b64a01000000000000000441430000000000046d656d6f"
			},
			"context_free": false,
			"elapsed": 220,
			"console": "",
			"trx_id": "c564e82c4d0e3c3c781d162c333bede9d83a86ad82c53d23a45fb55c9ff81381",
			"block_num": 26850202,
			"block_time": "2018-11-14T06:27:33.000",
			"producer_block_id": null,
			"account_ram_deltas": [],
			"except": null,
			"inline_traces": [{
				"receipt": {
					"receiver": "visualvisual",
					"act_digest": "f09112caec978b647defbc459656b87b1eaf04e1f4ec9c2a10f47d009bfdf592",
					"global_sequence": 1579377541,
					"recv_sequence": 1780,
					"auth_sequence": [
						["visualvisual", 1700]
					],
					"code_sequence": 1,
					"abi_sequence": 1
				},
				"act": {
					"account": "aircoin.eos",
					"name": "transfer",
					"authorization": [{
						"actor": "visualvisual",
						"permission": "active"
					}],
					"data": {
						"from": "visualvisual",
						"to": "developer.x",
						"quantity": "0.0001 AC",
						"memo": "memo"
					},
					"hex_data": "108dc66e47a3b1db003ab8aad2a8b64a01000000000000000441430000000000046d656d6f"
				},
				"context_free": false,
				"elapsed": 8,
				"console": "",
				"trx_id": "c564e82c4d0e3c3c781d162c333bede9d83a86ad82c53d23a45fb55c9ff81381",
				"block_num": 26850202,
				"block_time": "2018-11-14T06:27:33.000",
				"producer_block_id": null,
				"account_ram_deltas": [],
				"except": null,
				"inline_traces": []
			}, {
				"receipt": {
					"receiver": "developer.x",
					"act_digest": "f09112caec978b647defbc459656b87b1eaf04e1f4ec9c2a10f47d009bfdf592",
					"global_sequence": 1579377542,
					"recv_sequence": 34,
					"auth_sequence": [
						["visualvisual", 1701]
					],
					"code_sequence": 1,
					"abi_sequence": 1
				},
				"act": {
					"account": "aircoin.eos",
					"name": "transfer",
					"authorization": [{
						"actor": "visualvisual",
						"permission": "active"
					}],
					"data": {
						"from": "visualvisual",
						"to": "developer.x",
						"quantity": "0.0001 AC",
						"memo": "memo"
					},
					"hex_data": "108dc66e47a3b1db003ab8aad2a8b64a01000000000000000441430000000000046d656d6f"
				},
				"context_free": false,
				"elapsed": 36,
				"console": "",
				"trx_id": "c564e82c4d0e3c3c781d162c333bede9d83a86ad82c53d23a45fb55c9ff81381",
				"block_num": 26850202,
				"block_time": "2018-11-14T06:27:33.000",
				"producer_block_id": null,
				"account_ram_deltas": [],
				"except": null,
				"inline_traces": []
			}]
		}],
		"except": null
	}
}
```
### 自定义合约
`调用:`
```kotlin
val entity = StarteosActionEntity("test")
entity.accountName = "visualvisual"//调用合约的账号名
entity.accountAddress = "EOS6k6yWS3mPbQ7AhdfSdvxHPFaJfCe2yFSWsaNK1oioMJq92ccbm"//调用合约的账号公钥
entity.hint = "for test"//界面上给用户展示的说明
val action = StarteosActionEntity.Action()//合约，支持多个合约调用
action.contractName = "developer.x"//合约地址
action.actionName = "hi"//合约方法
action.putData("user", "visualvisual")//合约需要的参数，value是Object类型，传参是请注意类型，转换成json字符串后能够正确的调用合约
entity.addAction(action)
StarteosSDKHelper.getInstance().execute(this, entity, object : StarteosSDKListener {
    override fun success(result: JSONObject?) {
    }

    override fun error(code: Int, message: String?) {
        //当code==-10007时，message为链上原始错误信息
    }
})
```
`结果:`
```json
{
	"transaction_id": "ffb7a8a2a07e056540a89672c0283034febb8fd39bf15c11abf9ad03786c7af8",
	"processed": {
		"id": "ffb7a8a2a07e056540a89672c0283034febb8fd39bf15c11abf9ad03786c7af8",
		"block_num": 26851577,
		"block_time": "2018-11-14T06:39:01.000",
		"producer_block_id": null,
		"receipt": {
			"status": "executed",
			"cpu_usage_us": 394,
			"net_usage_words": 13
		},
		"elapsed": 394,
		"net_usage": 104,
		"scheduled": false,
		"action_traces": [{
			"receipt": {
				"receiver": "developer.x",
				"act_digest": "cdcc335dfa1d1d5825fa2c606cfb4e760c946a4b6131311d31fca675f00161ef",
				"global_sequence": 1579789143,
				"recv_sequence": 37,
				"auth_sequence": [
					["visualvisual", 1704]
				],
				"code_sequence": 2,
				"abi_sequence": 2
			},
			"act": {
				"account": "developer.x",
				"name": "hi",
				"authorization": [{
					"actor": "visualvisual",
					"permission": "active"
				}],
				"data": {
					"user": "visualvisual"
				},
				"hex_data": "108dc66e47a3b1db"
			},
			"context_free": false,
			"elapsed": 109,
			"console": "",
			"trx_id": "ffb7a8a2a07e056540a89672c0283034febb8fd39bf15c11abf9ad03786c7af8",
			"block_num": 26851577,
			"block_time": "2018-11-14T06:39:01.000",
			"producer_block_id": null,
			"account_ram_deltas": [],
			"except": null,
			"inline_traces": []
		}],
		"except": null
	}
}
```

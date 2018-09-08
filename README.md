# rpcblade

#### 项目介绍
第三方对接利器，像本地接口一样调用RPC（http、socket、netty等）

#### 实现说明
1. 使用 dubbo spi 的思想，涉及到RPC调用中的编码、解码、发送协议都支持本地扩展
2. 使用Spring FactoryBean，将自定义的 RPC 接口与 Spring 无缝集成。自动扫描 @RpcService 的 bean，纳入 Spring 容器管理

#### 使用说明
如果与 Spring 配合使用，则需要先配置 Rpc 组件扫描器：
>>>
    <bean class="com.kvn.blade.scan.RpcScannerConfigurer">
    	<property name="basePackage" value="com.kvn.rpc.service" />
    </bean>
参考：[application.xml](src/test/resources/application.xml)


1. 调用http服务
```java
@RpcService(protocol = "http", host = "172.16.21.28")
public interface HttpRpcService {
	
	@Addition("type=post&url=mockjsdata/35/refund/api/query/querySettlement")
	FooResponse call1030(FooRequest request);

}
```
参考：[HttpRpcService.java](src/test/java/com/kvn/rpc/service/HttpRpcService.java)

2. 调用socket服务
```java
@RpcService(protocol = "socket", host = "localhost:8091")
public interface SocketRpcService {
	
	XmlResponse call1030(XmlRequest request);

}
```
参考：[SocketRpcService.java](src/test/java/com/kvn/rpc/service/SocketRpcService.java)

3. 调用netty服务
```java
@RpcService(protocol = "netty", host = "localhost:8091")
public interface NettyRpcService {
	
	XmlResponse call1030(XmlRequest request);

}
```
参考：[NettyRpcService.java](src/test/java/com/kvn/rpc/service/NettyRpcService.java)
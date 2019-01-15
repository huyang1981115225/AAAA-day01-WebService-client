# WebService总结 #

## 1、WebService是什么？ ##

	1.1 基于Web的服务，服务器端整出一些资源让客户端应用访问

	1.2 一个跨语言、跨平台的规范

	1.3 多个跨语言、跨平台的应用间通信整合的方案

## 2、几个重要术语 ##

## 2.1 WSDL:   WebService definition language ##
	
	直译：WebService定义语言
	
	1、对应一种类型的文件：.wsdl

	2、定义了WebService的服务器端与客户端应用交互传递请求和相应数据的格式和方式

	3、一个WebService对应一个唯一的wsdl文档

## 2、2 SOAP: simple object access protocal ##

	直译：简单对象访问协议

	1、是一种简单的、基于HTTP和XML的协议，用于在WEB上交换结构化的数据。

	2、SOAP信息：请求消息和响应消息

	3、HTTP和XML

## 2、3 SEI：WebService EndPoint Interface ##

	直译：WebService的终端接口

	就是WebService服务器端用来处理请求的接口

## 2、4 CXF：Celt+XFire ##

	一个apache的用于开发服务器端和客户端的框架

## 3、HTTP协议 ##

## 3.1 HttpRequest ##

	请求的格式分成三个部分：请求行、消息头、消息正文

	CR:回车（\r）

	LF:换行（\n）

	1、请求行：  method    url             protocal
	例如：      Get       /index.html     HTTP/1.1CRLF

	2、消息头
	name1:value1CRLF
	name2:value2CRLF
	...
	CRLF     单独放送一个CRLF表示消息头全部发送完毕

	3、消息正文（略）

## 3、2 HttpResponse ##

	请求的格式分成三个部分：状态行、响应头、响应正文

	1、状态行：    协议版本        状态代码        状态描述
	例如：        HTTP/1.1       200            OKCRLF

	2、响应头（与消息头格式相同）

	3、响应正文（字节数据，是实际数据）

## 4、用Eclipse演示WebService   ##

	1、javaEE模式下，点击WebService浏览器（小地球右边的那个按钮）
![](https://i.imgur.com/J2gGK01.png)

	2、点击右边的wsdl Page (五角星左边的那个按钮)
![](https://i.imgur.com/W0b1sPd.png)

	3、点击WSDL Main
![](https://i.imgur.com/IoYoEhL.png)

	4、把复制好的wsdl url地址粘贴过来例如：
	http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl
![](https://i.imgur.com/9rNKi7o.png)

	5、go
![](https://i.imgur.com/OKxnffG.png)

	6、add
![](https://i.imgur.com/xUg2Hma.png)

	7、source
![](https://i.imgur.com/vyOVYVU.png)


## 5、开发WebService ##

## 5.1 使用jdk开发 ##

	1)开发服务器端

	webservice编码：
	
	-- @WebService(SEI和SEI的实现类)
![](https://i.imgur.com/927i9yN.png)

	-- @WebMethod(SEI中的所有方法)
![](https://i.imgur.com/29stnai.png)

	发布WebService

	-- EndPoint终端  发布WebService
![](https://i.imgur.com/fEKF0mQ.png)

	request:
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:q0="http://day01_webservice_ws.atguigu.cn/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	- <soapenv:Body>
	- <q0:introduce>
    <arg0>Jack</arg0> 
    <arg1>18</arg1> 
    </q0:introduce>
    </soapenv:Body>
    </soapenv:Envelope>

	response:
	- <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	- <S:Body>
	- <ns2:introduceResponse xmlns:ns2="http://day01_webservice_ws.atguigu.cn/">
    <return>I'm Jack,and I'm 18years old.</return> 
    </ns2:introduceResponse>
    </S:Body>
    </S:Envelope>


	2)开发客户端
	在客户端项目的src目录下cmd 执行 
	wsimport -keep url
	例如：wsimport -keep http://localhost:8989/AAAA-day01-WebService/hellows?wsdl
![](https://i.imgur.com/4k2U93S.png)

	这样会自动生成代码
![](https://i.imgur.com/5ZP6u4Y.png)

	编写测试代码
![](https://i.imgur.com/QavjCVt.png)

## 5、2 使用Eclipse的Tcp_IP工具(端口转发)监听WebService请求 ##
![](https://i.imgur.com/gWLx4UQ.png)
![](https://i.imgur.com/1h2X1xr.png)

	启动起来 这里配置了8088会转发到8089
![](https://i.imgur.com/vRHyv4h.png)

	本地wsdl文件自动生成代码
![](https://i.imgur.com/Hwaltzs.png)
![](https://i.imgur.com/WWWC2HJ.png)

## 5.3 编写天气预报查询WebService ##

	如果是.net写的WebService会出现问题
![](https://i.imgur.com/p3blYPx.png)

	解决方案：
	1、将对应的wsdl文件保存到本地
	2、修改wsdl文档的部分内容
	  将<s:element ref="s:schema" /><s:any />替换成<s:any minOccurs="2" maxOccurs="2"/>

![](https://i.imgur.com/5FMWnZr.png)

## 5.4 编写手机号码归属地查询WebService ##
![](https://i.imgur.com/WnjF5KO.png)
![](https://i.imgur.com/wcIk9wC.png)

## 5.5 编写中英双向翻译WebService ##
![](https://i.imgur.com/9tVTAkX.png)
![](https://i.imgur.com/2kngxnU.png)

## 6、wsdl文档深入分析 ##
![](https://i.imgur.com/Wk5rvMV.png)

## 6、1 文档结构 ##
![](https://i.imgur.com/VKT0Qsr.png)

## 6.2文档结构图 ##
![](https://i.imgur.com/gN2ZHfy.png)

## 6.3 重要标签的说明 ##
![](https://i.imgur.com/Fdbanwg.png)

## 	6.4演示cxf框架 ## 
	E:\JSD1708HY\APP\tts9\apache-cxf-2.5.9\bin   有一个wsdl12java
![](https://i.imgur.com/xXonQky.png)
![](https://i.imgur.com/k47Irlf.png)
![](https://i.imgur.com/PBObay6.png)

## 7、CXF支持的数据类型 ##

	--基本类型
	--引用类型
		--String
		--集合：List、Set、Map
		--自定义类型：Student

## 8、一次 Web service 请求的流程 ##
![](https://i.imgur.com/YZ9wN4M.png)

## 9、WebService面试题 ##
	
	1、webservice相当于 HTTP+XML   +schema(?)

	2、wsdl是什么
	直译：WebService定义语言,对应一种类型的文件：.wsdl,定义了WebService的服务器端与客户端应用交互传递请求和相应数据的格式和方式,一个WebService对应一个唯一的wsdl文档

	3、如何发布一个WebService
			定义SEI  @WebService @WebMethod
			定义SEI的实现    @WebService
			EndPoint.publish(url，SEI实现类)

	4、如何请求一个WebService
		1)根据wsdl文档生成客户端代码  
			jdk  ------wsport 
			cxf   ------- E:\JSD1708HY\APP\tts9\apache-cxf-2.5.9\bin\wsdl12java

		2)根据生成的代码调用WebService

## 10、cxf的拦截器 ##
![](https://i.imgur.com/m3SX3Cs.png)

## 10.1 拦截器 API ##
	
	Interceptor(拦截器接口)
		AbstractPhaseInterceptor(自定义拦截器从此继承)
		LoggingInInterceptor(系统日志入拦截器类)
		LoggingOutInterceptor(系统日志出拦截器类)
![](https://i.imgur.com/ZcUh4R7.png)
## 演示CXF的拦截器-----服务器端 ##
![](https://i.imgur.com/phdwENJ.png)
## 演示CXF的拦截器-----客户端 ##
![](https://i.imgur.com/zJww8dj.png)

## 11、用 CXF 编写基于 spring 的 web service ##
![](https://i.imgur.com/cVywUv0.png)

## 服务端 ##
![](https://i.imgur.com/YEUkX0q.png)
![](https://i.imgur.com/GsfJE5T.png)
![](https://i.imgur.com/zZZkqHv.png)
![](https://i.imgur.com/Z0vFy3O.png)

## 客户端 ##
![](https://i.imgur.com/63XRiGB.png)

## 结合Spring的情况下，如何自定义拦截器 ##

## 1. Server 端 ##
	
	– 在 beans.xml 中，在 endpoint 中配置上入拦截器
![](https://i.imgur.com/Ih4AGRt.png)

## 2. Client 端 ##

	– 通过 Client 对象设置出拦截器
![](https://i.imgur.com/983sEcW.png)

## 12、其他调用WebService的方式 ##
![](https://i.imgur.com/BMkuXAR.png)

## 12.1 Ajax调用WebService ##
## 获取Ajax对象，因为历史原因需要区分浏览器 ##
![](https://i.imgur.com/M9Ep1dX.png)
![](https://i.imgur.com/U7i2h2n.png)

## 12.2 Jquery请求webservice  ##
![](https://i.imgur.com/Zp4LONd.png)

## 12.3 HttpURLConnection 调用 WebService ##
![](https://i.imgur.com/ZuEP6RR.png)
![](https://i.imgur.com/M6iscvL.png)

## 13、通过注解修改 wsdl 文档 ##
![](https://i.imgur.com/990rAHv.png)
![](https://i.imgur.com/jDkrMYM.png)
![](https://i.imgur.com/3qcEnce.png)
![](https://i.imgur.com/kIvhT6r.png)
![](https://i.imgur.com/ikqQXXJ.png)
![](https://i.imgur.com/ViE8pCK.png)
![](https://i.imgur.com/qnKvBMH.png)
![](https://i.imgur.com/FW7Zks0.png)
![](https://i.imgur.com/lW0nS2H.png)
![](https://i.imgur.com/ErOAPTc.png)

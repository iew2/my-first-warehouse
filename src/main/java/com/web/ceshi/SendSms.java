package com.web.ceshi;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.3</version>
</dependency>
*/
public class SendSms {
    public static void main(String[] args) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G7a117fZ5XTMYvRPfo9", "asInIUO9zXZXqJxotoIY1K7Ah7gnsu");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18281595783");//写入要发送的手机号
        request.putQueryParameter("SignName", "jech项目");//这里改成自己的签名
        request.putQueryParameter("TemplateCode", "SMS_196652812");//这里是你模板里的模版CODE
        request.putQueryParameter("TemplateParam", "{code:\"xiaofaner\"}");//这里是你想要发送验证码的数字
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

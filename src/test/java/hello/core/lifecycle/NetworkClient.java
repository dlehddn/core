package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url: " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("종료 전 연결끊기");
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("의존관계 주입 후 초기화하기");
        connect();
        call("초기화 연결 메세지");
    }
}

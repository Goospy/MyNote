import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by Goospy on 2017/7/23.
 */
public class HelloRxJava {

    public static void main(String[] args) {
        Observable<HelloRxJava> sender = Observable.create(new Observable.OnSubscribe<HelloRxJava>() {
            public void call(Subscriber<? super HelloRxJava> subscriber) {

                subscriber.onNext(null);  //发送数据"Hi，Weavey！"
            }
        });

        Observer<HelloRxJava> receiver = new Observer<HelloRxJava>() {
            public void onCompleted() {

                //数据接收完成时调用
            }

            public void onError(Throwable e) {

                //发生错误调用
            }

            public void onNext(HelloRxJava s) {

                //正常接收数据调用
                System.out.print(s);  //将接收到来自sender的问候"Hi，Weavey！"
            }
        };

        sender.subscribe(receiver);

    }
}

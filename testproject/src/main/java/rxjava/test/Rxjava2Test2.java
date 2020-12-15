package rxjava.test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Rxjava2Test2 {
    public static void main(String[] args) {
        /**
         * onSubscribe
         * ok
         * onNext:连载1
         * onNext:连载2
         * onNext:连载3
         *
         * Process finished with exit code 0
         */
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    emitter.onNext("连载"+i);
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.computation())  //线程执行计划
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println("onNext:" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError=" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete()");
                    }
                });

        
        System.out.println("ok");
    }
}

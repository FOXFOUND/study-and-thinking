package rxjava.test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Rxjava2Test {
    public static void main(String[] args) {
        /**
         * onSubscribe
         * ok
         * onNext:连载1
         * onNext:连载2
         * onNext:连载3
         * onComplete()
         */
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())//执行在io线程
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

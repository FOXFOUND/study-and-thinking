package rxjava.test;


import io.reactivex.Observable;

public class RxjavaTest {
    public static void main(String[] args) {
        Observable.just("Hello, World!") // create new observable
                .subscribe(onNext -> { // subscribe and perform action
                    System.out.println(onNext);
                });

//        Observable<Integer> integerObservable = Observable.just(1, 2, 3); // Integer observable
//        Observable<String> stringObservable = Observable.just("Hello, ", "World", "!"); // String observable
//        Subscriber<Integer> mSubscriber = new Subscriber<Integer>() {
//            // NOTE THAT ALL THESE ARE CALLED BY THE OBSERVABLE
//            @Override
//            public void onCompleted() {
//                // called when all objects are emitted
//                System.out.println("onCompleted called!");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                // called when an error occurs during emitting objects
//                System.out.println("onError called!");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                // called for each object that is emitted
//                System.out.println("onNext called with: " + integer);
//            }
//        };
//        integerObservable.subscribe(mSubscriber);
//        integerObservable = Observable.just(11, 12, 13);
//        /**
//         * onNext called with: 1
//         * onNext called with: 2
//         * onNext called with: 3
//         * onCompleted called!
//         */
    }
}

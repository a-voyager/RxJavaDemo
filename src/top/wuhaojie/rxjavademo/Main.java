package top.wuhaojie.rxjavademo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class Main {

	private Observer<String> observer = new Observer<String>() {

		@Override
		public void onCompleted() {
			System.out.println("onCompleted");

		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError");

		}

		@Override
		public void onNext(String arg0) {
			System.out.println("item: " + arg0);

		}

	};

	private Observable<String> observable = Observable
			.create(new Observable.OnSubscribe<String>() {

				@Override
				public void call(Subscriber<? super String> s) {
					s.onNext("Hello");
					s.onNext("World");
					s.onNext("!");
					s.onCompleted();
				}

			});

	/**
	 * used for subscribe.
	 */
	public void begin() {
		observable.subscribe(observer);
	}

	public static void main(String[] args) {
		new Main().begin();
	}

}

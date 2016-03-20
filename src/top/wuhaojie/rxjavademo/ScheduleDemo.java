package top.wuhaojie.rxjavademo;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ScheduleDemo {

	public static void main(String[] args) {

		// 后台线程取数据，主线程显示:
		// .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
		// .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
		Observable.just(1, 2, 3, 4, 5).observeOn(Schedulers.immediate())
				.subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {

					@Override
					public void call(Integer arg0) {
						System.out.println(arg0.intValue());
					}
				});
		while (true)
			;
	}
}

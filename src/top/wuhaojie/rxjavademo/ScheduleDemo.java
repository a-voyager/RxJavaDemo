package top.wuhaojie.rxjavademo;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ScheduleDemo {

	public static void main(String[] args) {

		// ��̨�߳�ȡ���ݣ����߳���ʾ:
		// .subscribeOn(Schedulers.io()) // ָ�� subscribe() ������ IO �߳�
		// .observeOn(AndroidSchedulers.mainThread()) // ָ�� Subscriber �Ļص����������߳�
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

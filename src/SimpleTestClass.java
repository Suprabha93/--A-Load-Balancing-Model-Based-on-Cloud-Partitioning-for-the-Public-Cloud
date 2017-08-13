public class SimpleTestClass {

	static int x = 0;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		try {

			Thread t1 = new Thread();
			Thread t2 = new Thread();
			Thread t3 = new Thread();
			Thread t4 = new Thread();

			while (true) {

				t1.resume();
				x = 10;
				t2.suspend();
				t3.suspend();
				t4.suspend();

				Thread.sleep(1000);

				t2.resume();
				x = 20;
				t1.suspend();
				t3.suspend();
				t4.suspend();

				Thread.sleep(1000);

				t3.resume();
				x = 30;
				t2.suspend();
				t3.suspend();
				t4.suspend();

				Thread.sleep(1000);

				t4.resume();
				System.out.println("running thread is    :" + 4);
				x = 40;
				t1.suspend();
				t3.suspend();
				t2.suspend();
				Thread.sleep(1000);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

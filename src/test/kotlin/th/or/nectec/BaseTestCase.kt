package th.or.nectec

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
abstract class BaseTestCase {

    val DEFAULT_TIMEOUT = 15L

    lateinit var lock: CountDownLatch

    fun await(seconds: Long = DEFAULT_TIMEOUT) {
        lock.await(seconds, TimeUnit.SECONDS)
    }
}